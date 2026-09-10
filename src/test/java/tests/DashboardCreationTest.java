package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ManageDashboardPage;

public class DashboardCreationTest extends BaseTest {

    @Test(groups = {"regression"})
    public void openNewDashboardFormSuccessfully() throws InterruptedException {

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.openManageDashboards();

        ManageDashboardPage manageDashboardPage =
                new ManageDashboardPage(driver);

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

        DashboardPage createdDashboardPage =
                new DashboardPage(driver);

        String actualDashboardName =
                createdDashboardPage.getCurrentDashboardName();

        Assert.assertEquals(
                actualDashboardName,
                dashboardName,
                "Created dashboard name does not match the expected dashboard name"
        );

    }
}