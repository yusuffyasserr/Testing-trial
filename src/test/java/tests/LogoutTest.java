package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Credentials;

public class LogoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void logoutSuccessfully() {

        // =========================================
        // 1. Login
        // =========================================

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                Credentials.getUsername(),
                Credentials.getPassword()
        );

        pause();


        // =========================================
        // 2. Open user menu
        // =========================================

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.openUserMenu();

        pause();


        // =========================================
        // 3. Click Logout
        // =========================================

        dashboardPage.clickLogout();

        pause();


        // =========================================
        // 4. Verify Login page is displayed again
        // =========================================

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page was not displayed after logout"
        );

        pause();
    }
}