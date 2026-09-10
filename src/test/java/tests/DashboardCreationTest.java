package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardCreationTest extends BaseTest {

    @Test(groups = {"regression"})
    public void openNewDashboardFormSuccessfully() throws InterruptedException {

        dashboardPage.openManageDashboards();

        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );

        manageDashboardPage.openNewDashboardForm();

        Assert.assertTrue(
                manageDashboardPage.isNewDashboardFormDisplayed(),
                "New Dashboard form was not displayed"
        );

        String dashboardName =
                "AutoDashboard_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );

        manageDashboardPage.enterDashboardDescription(
                "Dashboard for automation"
        );

        manageDashboardPage.clickSubmit();

        String actualDashboardName =
                dashboardPage.getCurrentDashboardName();

        Assert.assertEquals(
                actualDashboardName,
                dashboardName,
                "Created dashboard name does not match the expected dashboard name"
        );

    }
}
