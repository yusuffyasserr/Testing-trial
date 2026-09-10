package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageDashboardPage;
import utils.Credentials;

public class DashboardEditTest extends BaseTest {

    @Test(groups = {"regression"})
    public void editDashboardSuccessfully() {

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
        // 2. Open Manage Dashboards
        // =========================================

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.openManageDashboards();

        pause();


        ManageDashboardPage manageDashboardPage =
                new ManageDashboardPage(driver);

        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );

        pause();


        // =========================================
        // 3. Open New Dashboard form
        // =========================================

        manageDashboardPage.openNewDashboardForm();

        pause();

        Assert.assertTrue(
                manageDashboardPage.isNewDashboardFormDisplayed(),
                "New Dashboard form was not displayed"
        );


        // =========================================
        // 4. Create a temporary dashboard
        // =========================================

        String dashboardName =
                "EditTest_" + System.currentTimeMillis();

        String dashboardDescription =
                "Temporary dashboard for edit regression test";

        manageDashboardPage.enterDashboardName(
                dashboardName
        );

        pause();

        manageDashboardPage.enterDashboardDescription(
                dashboardDescription
        );

        pause();

        manageDashboardPage.clickSubmit();

        pause();


        // =========================================
        // 5. Verify temporary dashboard was created
        // =========================================

        DashboardPage createdDashboardPage =
                new DashboardPage(driver);

        Assert.assertEquals(
                createdDashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );

        pause();


        // =========================================
        // 6. Open Dashboard Actions menu
        // =========================================

        createdDashboardPage.openDashboardActions();

        pause();


        // =========================================
        // 7. Click Edit Dashboard
        // =========================================

        createdDashboardPage.clickEditDashboard();

        pause();


        // =========================================
        // 8. Verify Edit Dashboard form opened
        // =========================================

        Assert.assertTrue(
                manageDashboardPage.isEditDashboardFormDisplayed(),
                "Edit Dashboard form was not displayed"
        );

        pause();


        // =========================================
        // 9. Prepare new dashboard values
        // =========================================

        String updatedDashboardName =
                "EditedDashboard_" + System.currentTimeMillis();

        String updatedDescription =
                "Updated successfully by Selenium regression automation";


        // =========================================
        // 10. Replace existing dashboard name
        // =========================================

        manageDashboardPage.replaceDashboardName(
                updatedDashboardName
        );

        pause();


        // =========================================
        // 11. Replace existing description
        // =========================================

        manageDashboardPage.replaceDashboardDescription(
                updatedDescription
        );

        pause();


        // =========================================
        // 12. Submit the edited dashboard
        // =========================================

        manageDashboardPage.clickSubmit();

        pause();


        // =========================================
        // 13. Verify dashboard name was updated
        // =========================================

        DashboardPage editedDashboardPage =
                new DashboardPage(driver);

        Assert.assertEquals(
                editedDashboardPage.getCurrentDashboardName(),
                updatedDashboardName,
                "Dashboard name was not updated successfully"
        );

        pause();
    }
}