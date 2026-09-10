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




        ManageDashboardPage manageDashboardPage =
                new ManageDashboardPage(driver);

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


        // Create temporary dashboard
        String dashboardName =
                "CloneTest_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );



        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard for clone regression test"
        );



        manageDashboardPage.clickSubmit();




        // Verify temporary dashboard was created
        DashboardPage createdDashboardPage =
                new DashboardPage(driver);

        Assert.assertEquals(
                createdDashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );




        // Open Dashboard Actions
        createdDashboardPage.openDashboardActions();




        // Click Clone Dashboard
        createdDashboardPage.clickCloneDashboard();


        // Verify clone success notification appeared,
        // then wait until it disappears
        createdDashboardPage
                .waitForCloneSuccessNotificationToDisappear();


    }
}