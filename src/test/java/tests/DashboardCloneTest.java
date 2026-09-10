package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ManageDashboardPage;

public class DashboardCloneTest extends BaseTest {

    @Test(groups = {"regression"})
    public void cloneDashboardSuccessfully() {

        // Open Manage Dashboards
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


        // Open New Dashboard form
        manageDashboardPage.openNewDashboardForm();

        pause();

        Assert.assertTrue(
                manageDashboardPage.isNewDashboardFormDisplayed(),
                "New Dashboard form was not displayed"
        );


        // Create temporary dashboard
        String dashboardName =
                "CloneTest_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );

        pause();

        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard for clone regression test"
        );

        pause();

        manageDashboardPage.clickSubmit();

        pause();


        // Verify temporary dashboard was created
        DashboardPage createdDashboardPage =
                new DashboardPage(driver);

        Assert.assertEquals(
                createdDashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );

        pause();


        // Open Dashboard Actions
        createdDashboardPage.openDashboardActions();

        pause();


        // Click Clone Dashboard
        createdDashboardPage.clickCloneDashboard();


        // Verify clone success notification appeared,
        // then wait until it disappears
        createdDashboardPage
                .waitForCloneSuccessNotificationToDisappear();

        pause();
    }
}