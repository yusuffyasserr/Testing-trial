package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    protected void pause() {

        int seconds =
                Integer.parseInt(
                        ConfigReader.get("actionDelay")
                );

        try {

            Thread.sleep(seconds * 1000L);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new RuntimeException(
                    "Test execution was interrupted during visual delay",
                    e
            );
        }
    }

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver();

        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}