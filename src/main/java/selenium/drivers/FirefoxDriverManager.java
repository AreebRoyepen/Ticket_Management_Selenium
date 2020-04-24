package selenium.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void createWebdriver() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        this.driver = new FirefoxDriver(firefoxOptions);
    }
}
