package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Credentials;

public class BaseTest {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

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

    @BeforeClass(alwaysRun = true)
    public void setUpBrowser() {

        driver = DriverFactory.createDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {

        driver.get(ConfigReader.get("baseUrl"));

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                Credentials.getUsername(),
                Credentials.getPassword()
        );

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.waitForDashboardToLoad();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}
