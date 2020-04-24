package selenium.reports;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ReportUtil {

    private int maxNumberOfArchivedReports = 9;
    private String archiveSource = System.getProperty("user.dir") + "/target/surefire-reports/";
    private String archiveDestination = null;

    private String archiveBase = System.getProperty("user.dir") + "/reports";

    private String tester = System.getProperty("user.name");

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy H.m.s");

    public ReportUtil() {
        Date date = new Date();
        String testDate = dateFormat.format(date);

        String reportLocation = this.tester + " " + testDate;
        this.archiveDestination = System.getProperty("user.dir") + "/reports/" + reportLocation;

        ///create directory if so
        this.makeDirectory(this.archiveDestination);
    }

    public void archiveReport() {
        try {


            /* Create the source Path instance. */
            Path srcPathObj = Paths.get(archiveSource);

            /* Create the target Path instance. */
            Path destPathObj = Paths.get(archiveDestination);

            /* Rename source to target, replace it if target exist. */
            Files.move(srcPathObj, destPathObj, StandardCopyOption.REPLACE_EXISTING);

            ///trigger the report in the default browser
            ///String reportUrl = archiveDestination + "/index.html";
            ///openReport(reportUrl);

            //remove old reports
            purgeOldReports();

            //delete target folder
            purgeTargetFolder();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    void purgeTargetFolder() {
        File targetFolder = new File(System.getProperty("user.dir") + "/target");

        //delete subfolders
        deleteDir(targetFolder);

        targetFolder.delete();
    }

    private void purgeOldReports() {
        try {

            File dir = new File(archiveBase);
            int numberOfSubfolders = 1;
            File listDir[] = dir.listFiles();

            //sort by last modified by
            Arrays.sort(listDir, Comparator.comparingLong(File::lastModified).reversed());
            for (int i = 0; i < listDir.length; i++) {
                if (listDir[i].isDirectory()) {
                    numberOfSubfolders++;
                    System.out.println("Counter ++  " + numberOfSubfolders + " -- " + listDir[i].getName());


                    if (numberOfSubfolders > maxNumberOfArchivedReports) {
                        ////delete
                        System.out.println("wants to delete " + listDir[i].getName());
                        deleteDir(listDir[i]);

                        System.out.println("deleting folder" + listDir[i].getName());
                        listDir[i].delete();
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void deleteDir(File file) {

        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        System.out.println("deleting ... " + file.getName());
        file.delete();
    }

    private void makeDirectory(String directory) {
        try {
            File theDir = new File(directory);

            if (!theDir.exists()) {
                System.out.println("creating directory: " + theDir.getName());
                boolean result = false;

                try {
                    theDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("DIR created");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void openReport(String reportUrl) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Paths.get("").toAbsolutePath().toString());
        final String[] browsers = {"x-www-browser", "google-chrome",
                "firefox", "opera", "epiphany", "konqueror", "conkeror", "midori",
                "kazehakase", "mozilla"};
        final String errMsg = "Error attempting to launch web browser";

//        String url = System.getProperty("user.dir") + "/target/surefire-reports/index.html";
        try {  //attempt to use Desktop library from JDK 1.6+
            Class<?> d = Class.forName("java.awt.Desktop");
            d.getDeclaredMethod("browse",
                    new Class<?>[]{java.net.URI.class}).invoke(
                    d.getDeclaredMethod("getDesktop").invoke(null),
                    new Object[]{java.net.URI.create(reportUrl)});
        } catch (Exception ignore) {  //library not available or failed
            String osName = System.getProperty("os.name");
            try {
                if (osName.startsWith("Mac OS")) {
                    Class.forName("com.apple.eio.FileManager").getDeclaredMethod(
                            "openURL", new Class<?>[]{String.class}).invoke(null,
                            new Object[]{reportUrl});
                } else if (osName.startsWith("Windows"))
                    Runtime.getRuntime().exec(
                            "rundll32 url.dll,FileProtocolHandler " + reportUrl);
                else { //assume Unix or Linux
                    String browser = null;
                    for (String b : browsers)
                        if (browser == null && Runtime.getRuntime().exec(new String[]
                                {"which", b}).getInputStream().read() != -1)
                            Runtime.getRuntime().exec(new String[]{browser = b, reportUrl});
                    if (browser == null)
                        throw new Exception(Arrays.toString(browsers));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errMsg + "\n" + e.toString());
            }
        }
    }
}
