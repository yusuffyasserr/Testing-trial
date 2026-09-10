package listeners;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

        logger.info(
                "TEST STARTED: {}",
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info(
                "TEST PASSED: {}",
                result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error(
                "TEST FAILED: {}",
                result.getName()
        );

        logger.error(
                "FAILURE REASON:",
                result.getThrowable()
        );

        Object testInstance =
                result.getInstance();

        if (testInstance instanceof BaseTest) {

            BaseTest baseTest =
                    (BaseTest) testInstance;

            WebDriver driver =
                    baseTest.getDriver();

            if (driver != null) {

                String screenshotPath =
                        ScreenshotUtils.takeScreenshot(
                                driver,
                                result.getName()
                        );

                logger.info(
                        "SCREENSHOT SAVED: {}",
                        screenshotPath
                );
            }
        }
    }
}