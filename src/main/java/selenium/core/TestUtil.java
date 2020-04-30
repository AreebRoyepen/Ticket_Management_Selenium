package selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import selenium.config.ETarget;
import selenium.drivers.DriverManager;
import selenium.drivers.DriverManagerFactory;
import selenium.reports.ReportUtil;
import selenium.xception.InvalidConfig;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public abstract class TestUtil {

    public static final Logger logger = LoggerFactory.getLogger(TestUtil.class);

    ReportUtil util = new ReportUtil();

    public WebDriver driver;

    //targets by
    public ETarget CLASS = ETarget.CLASS;
    public ETarget ID = ETarget.ID;
    public ETarget TAG_NAME = ETarget.TAG_NAME;
    public ETarget CSS = ETarget.CSS;
    public ETarget NAME = ETarget.NAME;
    public ETarget LINK_TEXT = ETarget.LINK_TEXT;
    public ETarget XPATH = ETarget.XPATH;


    private DriverManager driverManager;

    @BeforeClass
    public void setupTest() {

        Reporter.log("Before testing");

        driverManager = DriverManagerFactory.getDriverManager();
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
    }

    /**
     * after class load the testing
     */
    @AfterClass
    public void viewReportAfterTest() {
        Reporter.log("AFTER testing..");

        driver.quit();

        //archive and load the report in your default browser
//        util.archiveReport();
    }

    /**
     * enter text to an input
     *
     * @param targetBy
     * @param target
     * @param value
     */
    public void enterText(ETarget targetBy, String target, String value) {

        try {

            driver.findElement(by(targetBy, target)).sendKeys(value);
        } catch (Exception e) {
            exitTestIfException(e);
        }
    }

    public void loadLink(String url) {
        driver.get(url);
    }

    public void uploadFile(ETarget targetBy, String target, String value) {

        try {
            String uploadPath = value.replace("\\", "/");
            driver.findElement(by(targetBy, target)).sendKeys(uploadPath);
        } catch (Exception e) {
            exitTestIfException(e);
        }
    }

    /**
     * get page text of the loaded page.
     *
     * @return
     */
    public String getPageTitle() {
        String text = null;
        try {
            text = driver.getTitle();
        } catch (Exception e) {
            exitTestIfException(e);
        }
        return text;
    }

    public void checkCheckBox(ETarget targetBy, String target) {
        try {
            WebElement checkBox = driver.findElement(by(targetBy, target));
            if (!checkBox.isSelected() && checkBox.isEnabled()) {
                checkBox.click();
            }
        } catch (Exception e) {

        }
    }

    public void checkallCheckboxes(ETarget targetBy, String target) {
        List<WebElement> els = driver.findElements(by(targetBy, target));

        // Using for each loop store all checkboxes into el
        for (WebElement el : els) {

            // Verify if checkbox in not selected then click
            if (!el.isSelected()) {
                el.click();
            }
        }
    }

    public void unCheckallCheckboxes(ETarget targetBy, String target) {
        List<WebElement> els = driver.findElements(by(targetBy, target));

        // Using for each loop store all checkboxes into el
        for (WebElement el : els) {

            // Verify if checkbox in not selected then click
            if (el.isSelected()) {
                el.click();
            }
        }
    }


    public void unCheckCheckBox(ETarget targetBy, String target) {
        try {
            WebElement checkBox = driver.findElement(by(targetBy, target));
            if (checkBox.isSelected() && checkBox.isEnabled()) {
                checkBox.click();
            }
        } catch (Exception e) {

        }
    }


    public void tickRadioButton(ETarget targetBy, String target) {
        try {
            WebElement checkBox = driver.findElement(by(targetBy, target));
            if (!checkBox.isSelected() && checkBox.isEnabled()) {
                checkBox.click();
            }
        } catch (Exception e) {

        }
    }

    /**
     * extract text from the element
     *
     * @param targetBy
     * @param target
     * @return
     */
    public String getText(ETarget targetBy, String target) {
        String text = null;
        try {

            text = driver.findElement(by(targetBy, target)).getText();
        } catch (Exception e) {
            exitTestIfException(e);
        }
        return text;
    }

    /**
     * select one item from the list by the visible text on dropdown
     *
     * @param targetBy
     * @param target
     * @param visibleText
     */
    public void selectOneByVisibleText(ETarget targetBy, String target, String visibleText) {

        Select select = new Select(driver.findElement(by(targetBy, target)));
        select.selectByVisibleText(visibleText);
    }

    /**
     * select one item from the list by its value
     *
     * @param targetBy
     * @param target
     * @param value
     */
    public void selectOneByValue(ETarget targetBy, String target, String value) {
        Select select = new Select(driver.findElement(by(targetBy, target)));
        select.selectByValue(value);
    }

    /**
     * select the item from the list by its index
     *
     * @param targetBy
     * @param target
     * @param index
     */
    public void selectOneByIndex(ETarget targetBy, String target, int index) {
        Select select = new Select(driver.findElement(by(targetBy, target)));
        select.selectByIndex(index);
    }


    /**
     * select multiple by drop down
     *
     * @param targetBy
     * @param target
     * @param mutipleVisbileTexts
     */
    public void selectMutipleByVisibleText(ETarget targetBy, String target, String[] mutipleVisbileTexts) {

        Select select = new Select(driver.findElement(by(targetBy, target)));
        Arrays.stream(mutipleVisbileTexts).forEach(visibleText -> {
            select.selectByVisibleText(visibleText);
        });

    }

    /**
     * select mutiple items by value e.g kuza,upia,anza
     *
     * @param targetBy
     * @param target
     * @param mutipleValues
     */
    public void selectMutipleByValue(ETarget targetBy, String target, String[] mutipleValues) {

        Select select = new Select(driver.findElement(by(targetBy, target)));
        Arrays.stream(mutipleValues).forEach(selectValue -> {
            select.selectByValue(selectValue);
        });

    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void click(ETarget targetBy, String target) {
        try {
            driver.findElement(by(targetBy, target)).click();
        } catch (Exception e) {
            exitTestIfException(e);
        }

    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void waitFor(long milliSeconds) {
        //driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        //WebDriverWait wait=new WebDriverWait(driver, seconds);
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void assertTest(String expected, String actual, String testMessage) {

        Assert.assertEquals(expected, actual);


    }

    public void assertTest(String expected, String actual) {
        try {
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            String message = e.getMessage().substring(0, 100);
            logger.error(message);
            System.exit(0);
        }

    }


    void exitTestIfException(Exception e) {
        ///get the first 100 characters for information only
        String message = e.getMessage().substring(0, 100);
        logger.error(message);
        logger.info("Running test script due to invalid call to action");

        Assert.assertFalse(false, message);
//        System.exit(0);
    }

    private By by(ETarget targetBy, String target) {
        switch (targetBy) {
            case ID:
                return By.id(target);
            case CSS:
                return By.cssSelector(target);
            case NAME:
                return By.name(target);
            case TAG_NAME:
                return By.tagName(target);
            case CLASS:
                return By.className(target);
            case LINK_TEXT:
                return By.linkText(target);
            case XPATH:
                return By.xpath(target);
            default:
                throw new InvalidConfig("Target By: " + targetBy + " not supported");

        }
    }
    

    public WebElement waitUntilElementIsDisplayed (ETarget targetBy, String target) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(by(targetBy, target)));
    	//WebElement element = waitForElement(targetBy, target);		
		//return element.isDisplayed();
	}
    

}
