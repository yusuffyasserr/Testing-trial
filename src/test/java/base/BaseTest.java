package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageDashboardPage;
import utils.ConfigReader;
import utils.Credentials;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ManageDashboardPage manageDashboardPage;

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

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        manageDashboardPage = new ManageDashboardPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {

        driver.get(ConfigReader.get("baseUrl"));

        loginPage.login(
                Credentials.getUsername(),
                Credentials.getPassword()
        );

        dashboardPage.waitForDashboardToLoad();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}
