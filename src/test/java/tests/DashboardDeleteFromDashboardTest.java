package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardDeleteFromDashboardTest extends BaseTest {

    @Test(groups = {"regression"})
    public void deleteDashboardFromOpenedDashboardSuccessfully() {

        // Open Manage Dashboards
        dashboardPage.openManageDashboards();

        // Verify Manage Dashboards page
        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );

        // Open New Dashboard form
        manageDashboardPage.openNewDashboardForm();

        Assert.assertTrue(
                manageDashboardPage.isNewDashboardFormDisplayed(),
                "New Dashboard form was not displayed"
        );

        // Create unique temporary dashboard
        String dashboardName =
                "DeleteFromDashboard_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );

        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard for delete-from-dashboard regression test"
        );

        manageDashboardPage.clickSubmit();

        // Verify that the temporary dashboard opened
        Assert.assertEquals(
                dashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );

        // Open Dashboard Actions
        dashboardPage.openDashboardActions();

        dashboardPage.clickDeleteDashboard();

        dashboardPage.confirmDeleteDashboard();

        dashboardPage.waitForDeleteSuccessNotificationToDisappear();

        dashboardPage.openManageDashboards();

        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed after deletion"
        );

        // Search for the deleted dashboard
        manageDashboardPage.searchDashboard(
                dashboardName
        );

        // Final verification
        Assert.assertTrue(
                manageDashboardPage.isNoDataMessageDisplayed(),
                "Dashboard still exists after deleting it from the Dashboard page"
        );
    }
}
