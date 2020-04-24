package selenium.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebdriver() {
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }
}
