package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By usernameField =
            By.name("username");

    private final By passwordField =
            By.cssSelector("input[placeholder='Enter Password']");

    private final By loginButton =
            By.xpath("//button[normalize-space()='Login']");

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15)
                );
    }

    public void enterUsername(String username) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField
                )
        ).sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        ).sendKeys(password);
    }

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();
    }

    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }

    public boolean isLoginButtonDisplayed() {

        return !driver.findElements(loginButton).isEmpty();
    }
}