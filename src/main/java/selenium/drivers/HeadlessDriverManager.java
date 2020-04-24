package selenium.drivers;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HeadlessDriverManager  extends DriverManager {

    @Override
    protected void createWebdriver() {

        this.driver =  new PhantomJSDriver();
    }

}
