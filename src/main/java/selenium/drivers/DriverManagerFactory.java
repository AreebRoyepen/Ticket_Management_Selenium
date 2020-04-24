package selenium.drivers;

import selenium.xception.InvalidConfig;

import selenium.config.DriverType;

public class DriverManagerFactory {

    static DriverManager driverManager;

    public static DriverManager getDriverManager() {

        System.out.println("---------------------------------------------------");
        ///if -Dbrowser not set in command line, set default to HEADLESS.
        String passedBrowser = System.getProperty("browser", "CHROME").toUpperCase();
        System.out.println("Test Browser: " + passedBrowser);

        ///convert to driver type to see if is supported
        DriverType driverType = DriverType.valueOf(passedBrowser);


        //set the driver environment
        switch (driverType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", readDriverLocation(driverType));
                //remove firefox logs

                driverManager = new FirefoxDriverManager();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", readDriverLocation(driverType));
                driverManager = new ChromeDriverManager();
                break;
            case HEADLESS:
                /**
                 * we are using phantomjs library driver
                 */
                System.setProperty("phantomjs.binary.path", readDriverLocation(driverType));

                driverManager = new HeadlessDriverManager();
                break;
            default:
                String message = String.format("%s browser driver not supported. ", driverType.toString());
                throw new InvalidConfig(message);

        }
        System.out.println("---------------------------------------------------");
        return driverManager;
    }

    private static String readDriverLocation(DriverType driverType) {
        String driverLocation = "NOT_SUPPORTED";
        String os = getOsName();

        //windows
        if (os.startsWith("Windows")) {
            System.out.println("Test OS: Windows");
            if (driverType.equals(DriverType.FIREFOX)) {
                driverLocation = "drivers/win/geckodriver.exe";
            }

            if (driverType.equals(DriverType.CHROME)) {
                driverLocation = "drivers/win/chromedriver.exe";
            }
            if (driverType.equals(DriverType.HEADLESS)) {
                driverLocation = "drivers/win/phantomjs.exe";
            }
        }

        ////linux
        if (os.indexOf("nux") >= 0) {
            System.out.println("Test OS: LINUX");
            if (driverType.equals(DriverType.FIREFOX)) {
                //driver for 64 bit
                driverLocation = "drivers/linux/geckodriver-64";
            }

            if (driverType.equals(DriverType.CHROME)) {
                driverLocation = "drivers/linux/chromedriver";
            }

            if (driverType.equals(DriverType.HEADLESS)) {
                driverLocation = "drivers/linux/phantomjs";
            }

        }

        //mac os x
        if ((os.indexOf("Mac") >= 0)) {
            System.out.println("Test OS: MAC OS X");
            if (driverType.equals(DriverType.FIREFOX)) {
                //driver for 64 bit
                driverLocation = "drivers/mac/geckodriver";
            }
            if (driverType.equals(DriverType.CHROME)) {
                driverLocation = "drivers/mac/chromedriver";
            }
            if (driverType.equals(DriverType.HEADLESS)) {
                driverLocation = "drivers/mac/phantomjs";
            }

        }

        return driverLocation;
    }

    public static String getOsName() {
        String OS = null;
        if (OS == null) {
            OS = System.getProperty("os.name");
            System.out.println("OS NAME:::>>>> " +OS);
        }
        return OS;
    }
}
