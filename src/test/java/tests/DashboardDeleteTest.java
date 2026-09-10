package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardDeleteTest extends BaseTest {

    @Test(groups = {"alternative"})
    public void deleteDashboardSuccessfully() {

        // 2. Open Manage Dashboards
        dashboardPage.openManageDashboards();



        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );

        // 3. Open New Dashboard form
        manageDashboardPage.openNewDashboardForm();



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



        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard created for delete regression test"
        );



        manageDashboardPage.clickSubmit();



        System.out.println("STEP 1: Dashboard submitted");

        // Verify temporary dashboard was created
        Assert.assertEquals(
                dashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );

        System.out.println("STEP 2: Temporary dashboard verified");



        System.out.println("STEP 3: Opening Manage Dashboards");

        dashboardPage.openManageDashboards();

        System.out.println("STEP 4: Manage Dashboards button clicked");



        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );

        System.out.println("STEP 5: Manage Dashboards page verified");



        manageDashboardPage.searchDashboard(
                dashboardName
        );

        System.out.println("STEP 6: Dashboard searched");


        manageDashboardPage.clickDeleteDashboard();

        manageDashboardPage.confirmDelete();
        System.out.println("STEP 7: Dashboard deleted successfully");


        Assert.assertTrue(
                manageDashboardPage.isNoDataMessageDisplayed(),
                "Deleted dashboard is still displayed in the search results"
        );
    }
}
