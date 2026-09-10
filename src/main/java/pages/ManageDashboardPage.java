package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class ManageDashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By manageDashboardsTitle =
            By.xpath("//h5[@class='headerTitle' and normalize-space()='Manage Dashboards']");

    private final By addDashboardButton =
            By.id("addDashboard");

    private final By dashboardOption =
            By.xpath(
                    "//ul[@aria-labelledby='addDashboard']//a[normalize-space()='Dashboard']"
            );

    private final By newDashboardTitle =
            By.xpath("//h6[@class='title-text' and normalize-space()='New Dashboard']");

    private final By dashboardNameField =
            By.name("name");

    private final By dashboardDescriptionField =
            By.name("description");

    private final By submitButton =
            By.cssSelector("button.submitForm-btn");

    private final By dashboardSearchField =
            By.cssSelector("input.Dashboards-search-input");

    private final By deleteDashboardButton =
            By.cssSelector("button[tooltip='Delete Dashboard']");

    private final By confirmDeleteButton =
            By.cssSelector("button[data-bb-handler='confirm']");

    private final By noDataMessage =
            By.xpath("//*[normalize-space()='No data available in table']");

    private final By editDashboardTitle =
            By.xpath(
                    "//h6[@class='title-text' and normalize-space()='Edit Dashboard']"
            );

    public ManageDashboardPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public boolean isManageDashboardsPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        manageDashboardsTitle
                )
        ).isDisplayed();
    }

    public void openAddDashboardMenu() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addDashboardButton
                )
        ).click();
    }

    public void selectDashboardOption() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        dashboardOption
                )
        ).click();
    }

    public boolean isNewDashboardFormDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        newDashboardTitle
                )
        ).isDisplayed();
    }

    public void enterDashboardName(String dashboardName) {

        var nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboardNameField
                )
        );

        nameField.clear();
        nameField.sendKeys(dashboardName);
    }

    public void enterDashboardDescription(String description) {

        var descriptionField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboardDescriptionField
                )
        );

        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void clickSubmit() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        submitButton
                )
        ).click();
    }

    public void searchDashboard(String dashboardName) {

        var searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboardSearchField
                )
        );

        searchField.clear();

        searchField.sendKeys(dashboardName);

        searchField.sendKeys(Keys.ENTER);
    }

    public void clickDeleteDashboard() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        deleteDashboardButton
                )
        ).click();
    }

    public void confirmDelete() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        confirmDeleteButton
                )
        ).click();
    }

    public boolean isNoDataMessageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        noDataMessage
                )
        ).isDisplayed();
    }

    public void openNewDashboardForm() {

        openAddDashboardMenu();

        selectDashboardOption();
    }


    public boolean isEditDashboardFormDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        editDashboardTitle
                )
        ).isDisplayed();
    }

    public void replaceDashboardName(String newDashboardName) {

        var nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboardNameField
                )
        );

        nameField.click();

        nameField.sendKeys(
                Keys.CONTROL,
                "a"
        );

        nameField.sendKeys(Keys.BACK_SPACE);

        nameField.sendKeys(newDashboardName);
    }

    public void replaceDashboardDescription(String newDescription) {

        var descriptionField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboardDescriptionField
                )
        );

        descriptionField.click();

        descriptionField.sendKeys(
                Keys.CONTROL,
                "a"
        );

        descriptionField.sendKeys(Keys.BACK_SPACE);

        descriptionField.sendKeys(newDescription);
    }


}