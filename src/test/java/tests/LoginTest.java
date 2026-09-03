package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    private final String loginUrl =
            "http://192.168.125.30:8080/#/";

    private final By usernameField =
            By.name("username");

    private final By passwordField =
            By.cssSelector("input[placeholder='Enter Password']");

    private final By loginButton =
            By.xpath("//button[normalize-space()='Login']");

    @Test
    public void loginSuccessfully() throws InterruptedException {

        String username = System.getenv("CMS_USERNAME");
        String password = System.getenv("CMS_PASSWORD");

        Assert.assertNotNull(
                username,
                "CMS_USERNAME environment variable is missing."
        );

        Assert.assertNotNull(
                password,
                "CMS_PASSWORD environment variable is missing."
        );

        driver = new ChromeDriver();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();

        System.out.println("Step 1: Opening login page");
        driver.get(loginUrl);

        pause(2);

        System.out.println("Step 2: Entering username");

        WebElement usernameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );

        usernameInput.sendKeys(username);

        pause(2);

        System.out.println("Step 3: Entering password");

        WebElement passwordInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        );

        passwordInput.sendKeys(password);

        pause(2);

        System.out.println("Step 4: Clicking Login");

        WebElement login = wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );

        login.click();

        pause(3);

        System.out.println("Step 5: Verifying successful login");

        wait.until(driver ->
                !driver.getCurrentUrl().equals(loginUrl)
                        || isLoginButtonGone()
        );

        boolean loginSucceeded =
                !driver.getCurrentUrl().equals(loginUrl)
                        || isLoginButtonGone();

        Assert.assertTrue(
                loginSucceeded,
                "Login failed. The login page is still displayed."
        );

        System.out.println("Login completed successfully");

        pause(5);
    }

    private boolean isLoginButtonGone() {
        return driver.findElements(loginButton)
                .stream()
                .noneMatch(WebElement::isDisplayed);
    }

    private void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}