package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardFavoriteTest extends BaseTest {

    @Test(groups = {"regression"})
    public void favoriteAndUnfavoriteDashboardSuccessfully() {

        // =========================================
        // 2. Open Manage Dashboards
        // =========================================

        dashboardPage.openManageDashboards();




        Assert.assertTrue(
                manageDashboardPage.isManageDashboardsPageDisplayed(),
                "Manage Dashboards page was not displayed"
        );



        // =========================================
        // 3. Create temporary dashboard
        // =========================================

        manageDashboardPage.openNewDashboardForm();



        String dashboardName =
                "FavoriteTest_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );



        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard for favorite regression test"
        );



        manageDashboardPage.clickSubmit();




        // =========================================
        // 4. Verify dashboard was created
        // =========================================

        Assert.assertEquals(
                dashboardPage.getCurrentDashboardName(),
                dashboardName,
                "Temporary dashboard was not created successfully"
        );



        // =========================================
        // 5. Verify initial state is Unfavorite
        // =========================================

        Assert.assertTrue(
                dashboardPage.isDashboardUnfavorite(),
                "Dashboard should initially be unfavorite"
        );



        // =========================================
        // 6. Favorite Dashboard
        // =========================================

        dashboardPage.clickFavoriteButton();

        Assert.assertTrue(
                dashboardPage.isDashboardFavorite(),
                "Dashboard was not marked as favorite"
        );




        // =========================================
        // 7. Un-Favorite Dashboard
        // =========================================

        dashboardPage.clickFavoriteButton();

        Assert.assertTrue(
                dashboardPage.isDashboardUnfavorite(),
                "Dashboard was not removed from favorites"
        );


    }
}
