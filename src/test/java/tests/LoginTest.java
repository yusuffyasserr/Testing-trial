package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Credentials;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void loginSuccessfully()
            throws InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                Credentials.getUsername(),
                Credentials.getPassword()
        );

        Thread.sleep(3000);

        Assert.assertFalse(
                loginPage.isLoginButtonDisplayed(),
                "Login failed. Login page is still displayed."
        );
    }
}