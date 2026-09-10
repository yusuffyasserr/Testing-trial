package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void logoutSuccessfully() {

        // =========================================
        // 1. Open user menu
        // =========================================

        dashboardPage.openUserMenu();




        // =========================================
        // 2. Click Logout
        // =========================================

        dashboardPage.clickLogout();




        // =========================================
        // 3. Verify Login page is displayed again
        // =========================================

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page was not displayed after logout"
        );


    }
}
