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

    private final By dashboardActionsButton =
            By.id("designSpaceActionMenu");

    private final By deleteDashboardOption =
            By.id("deleteDesignSpace");

    private final By deleteConfirmationModal =
            By.cssSelector(
                    "div.bootbox.modal.bootbox-confirm[role='dialog']"
            );

    private final By confirmDeleteButton =
            By.cssSelector(
                    "div.bootbox.modal.bootbox-confirm " +
                            "button[data-bb-handler='confirm']"
            );


    private final By deleteSuccessNotification =
            By.xpath(
                    "//div[contains(@class,'notification-success')" +
                            " and .//h4[normalize-space()='Delete Dashboard']]"
            );

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

    public void openDashboardActions() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        dashboardActionsButton
                )
        ).click();
    }

    public void clickDeleteDashboard() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        deleteDashboardOption
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        deleteConfirmationModal
                )
        );
    }

    public void confirmDeleteDashboard() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        confirmDeleteButton
                )
        ).click();

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        deleteConfirmationModal
                )
        );
    }

    public void waitForDeleteSuccessNotificationToDisappear() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        deleteSuccessNotification
                )
        );

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        deleteSuccessNotification
                )
        );
    }
}