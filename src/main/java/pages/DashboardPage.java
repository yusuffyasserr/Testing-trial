package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // locators
    private final By manageDashboardButton =
            By.id("manageDashboard");

    private final By currentDashboardName =
            By.cssSelector("label.navBtnText");

    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public void openManageDashboards() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        manageDashboardButton
                )
        ).click();
    }

    public String getCurrentDashboardName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        currentDashboardName
                )
        ).getText().trim();
    }
}