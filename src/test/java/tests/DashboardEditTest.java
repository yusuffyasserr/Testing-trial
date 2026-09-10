package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardEditTest extends BaseTest {

    @Test(groups = {"regression"})
    public void editDashboardSuccessfully() {

        // =========================================
        // 2. Open Manage Dashboards
        // =========================================

        dashboardPage.openManageDashboards();



        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );




        // =========================================
        // 3. Open New Dashboard form
        // =========================================

        manageDashboardPage.openNewDashboardForm();



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



        manageDashboardPage.enterDashboardDescription(
                dashboardDescription
        );



        manageDashboardPage.clickSubmit();




        // =========================================
        // 5. Verify temporary dashboard was created
        // =========================================

        Assert.assertEquals(
                dashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );




        // =========================================
        // 6. Open Dashboard Actions menu
        // =========================================

        dashboardPage.openDashboardActions();




        // =========================================
        // 7. Click Edit Dashboard
        // =========================================

        dashboardPage.clickEditDashboard();




        // =========================================
        // 8. Verify Edit Dashboard form opened
        // =========================================

        Assert.assertTrue(
                manageDashboardPage.isEditDashboardFormDisplayed(),
                "Edit Dashboard form was not displayed"
        );




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




        // =========================================
        // 11. Replace existing description
        // =========================================

        manageDashboardPage.replaceDashboardDescription(
                updatedDescription
        );




        // =========================================
        // 12. Submit the edited dashboard
        // =========================================

        manageDashboardPage.clickSubmit();




        // =========================================
        // 13. Verify dashboard name was updated
        // =========================================

        Assert.assertEquals(
                dashboardPage.getCurrentDashboardName(),
                updatedDashboardName,
                "Dashboard name was not updated successfully"
        );

    }
}
