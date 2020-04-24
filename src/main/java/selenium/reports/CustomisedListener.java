package selenium.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomisedListener implements ITestListener {
    private final Logger logger = LoggerFactory.getLogger("CUSTOM_LOGS");

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Started testing on: " + iTestResult.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Skipped Test: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("Testing: " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("PASSED TEST CASES");
        iTestContext.getPassedTests().getAllResults()
                .forEach(result -> {
                    logger.info(result.getName());
                });

        logger.info("FAILED TEST CASES");
        iTestContext.getFailedTests().getAllResults()
                .forEach(result -> {
                    logger.info(result.getName());
                });

        logger.info(
                "Test completed on: " + iTestContext.getEndDate().toString());
    }
}
