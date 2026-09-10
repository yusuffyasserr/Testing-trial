package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

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

    private final By editDashboardOption =
            By.id("editDesignSpace");


    private final By deleteSuccessNotification =
            By.xpath(
                    "//div[contains(@class,'notification-success')" +
                            " and .//h4[normalize-space()='Delete Dashboard']]"
            );

    private final By cloneDashboardOption =
            By.id("cloneDesignSpace");

    private final By cloneSuccessNotification =
            By.xpath(
                    "//div[contains(@class,'notification-success')" +
                            " and .//h4[normalize-space()='Clone Dashboard']]"
            );

    private final By favoriteButton =
            By.cssSelector(
                    "button[tooltip='Favorite / Unfavorite']"
            );

    private final By unfavoriteState =
            By.cssSelector(
                    "button[tooltip='Favorite / Unfavorite'] i.ev-star-o"
            );

    private final By favoriteState =
            By.cssSelector(
                    "button[tooltip='Favorite / Unfavorite'] i.ev-star.ev-text-warning"
            );

    private final By userMenu =
            By.id("logout");

    private final By logoutOption =
            By.cssSelector(
                    "ul[aria-labelledby='logout'] a[href='logout']"
            );

    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.get("timeout"))
                )
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

    public void clickEditDashboard() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        editDashboardOption
                )
        ).click();
    }

    public void clickCloneDashboard() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cloneDashboardOption
                )
        ).click();
    }

    public void waitForCloneSuccessNotificationToDisappear() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cloneSuccessNotification
                )
        );

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        cloneSuccessNotification
                )
        );
    }

    //Favourite/Unfavourite Feature
    public void clickFavoriteButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        favoriteButton
                )
        ).click();
    }
    public boolean isDashboardFavorite() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        favoriteState
                )
        ).isDisplayed();
    }
    public boolean isDashboardUnfavorite() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        unfavoriteState
                )
        ).isDisplayed();
    }

    // for logout
    public void openUserMenu() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        userMenu
                )
        ).click();
    }
    public void clickLogout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        logoutOption
                )
        ).click();
    }

}