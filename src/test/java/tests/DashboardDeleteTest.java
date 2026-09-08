package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageDashboardPage;
import utils.Credentials;

public class DashboardDeleteTest extends BaseTest {

    @Test(groups = {"regression"})
    public void deleteDashboardSuccessfully() {

        // 1. Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                Credentials.getUsername(),
                Credentials.getPassword()
        );

        pause();

        // 2. Open Manage Dashboards
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

        // 3. Open New Dashboard form
        manageDashboardPage.openNewDashboardForm();

        pause();

        Assert.assertTrue(
                manageDashboardPage.isNewDashboardFormDisplayed(),
                "New Dashboard form was not displayed"
        );

        // 4. Create temporary dashboard
        String dashboardName =
                "DeleteTest_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );

        pause();

        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard created for delete regression test"
        );

        pause();

        manageDashboardPage.clickSubmit();

        pause();

        System.out.println("STEP 1: Dashboard submitted");

        // Verify temporary dashboard was created
        DashboardPage createdDashboardPage =
                new DashboardPage(driver);

        Assert.assertEquals(
                createdDashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );

        System.out.println("STEP 2: Temporary dashboard verified");

        pause();

        System.out.println("STEP 3: Opening Manage Dashboards");

        createdDashboardPage.openManageDashboards();

        System.out.println("STEP 4: Manage Dashboards button clicked");

        pause();

        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );

        System.out.println("STEP 5: Manage Dashboards page verified");

        pause();

        manageDashboardPage.searchDashboard(
                dashboardName
        );

        System.out.println("STEP 6: Dashboard searched");
        pause();

        manageDashboardPage.clickDeleteDashboard();
        pause();
        manageDashboardPage.confirmDelete();
        System.out.println("STEP 7: Dashboard deleted successfully");
        pause();

        Assert.assertTrue(
                manageDashboardPage.isNoDataMessageDisplayed(),
                "Deleted dashboard is still displayed in the search results"
        );
    }
}