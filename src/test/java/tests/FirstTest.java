package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstTest {

    private WebDriver driver;

    @Test
    public void openSeleniumWebsite() throws InterruptedException {

        driver = new ChromeDriver();

        // Wait after opening Chrome
        Thread.sleep(3000);

        driver.manage().window().maximize();

        // Wait after maximizing
        Thread.sleep(3000);

        driver.get("https://www.selenium.dev/");

        // Keep the website open for 7 seconds
        Thread.sleep(7000);

        String pageTitle = driver.getTitle();

        System.out.println("Page title: " + pageTitle);

        Assert.assertTrue(
                pageTitle.contains("Selenium"),
                "The Selenium website did not open correctly."
        );

        // Wait before closing Chrome
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}