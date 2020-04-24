package selenium.drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createWebdriver();

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() {
        if (driver == null) {
            createWebdriver();
        }
        return driver;
    }

}
