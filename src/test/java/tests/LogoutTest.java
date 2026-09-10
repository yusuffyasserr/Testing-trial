package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void logoutSuccessfully() {

        // =========================================
        // 1. Open user menu
        // =========================================

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.openUserMenu();

        pause();


        // =========================================
        // 2. Click Logout
        // =========================================

        dashboardPage.clickLogout();

        pause();


        // =========================================
        // 3. Verify Login page is displayed again
        // =========================================

        LoginPage loginPage =
                new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page was not displayed after logout"
        );

        pause();
    }
}
