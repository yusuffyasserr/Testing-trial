package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ManageDashboardPage;

public class DashboardFavoriteTest extends BaseTest {


    @Test(groups = {"regression"})
    public void favoriteAndUnfavoriteDashboardSuccessfully() {

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
        // 3. Create temporary dashboard
        // =========================================

        manageDashboardPage.openNewDashboardForm();

        pause();

        String dashboardName =
                "FavoriteTest_" + System.currentTimeMillis();

        manageDashboardPage.enterDashboardName(
                dashboardName
        );

        pause();

        manageDashboardPage.enterDashboardDescription(
                "Temporary dashboard for favorite regression test"
        );

        pause();

        manageDashboardPage.clickSubmit();

        pause();


        // =========================================
        // 4. Verify dashboard was created
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
        // 5. Verify initial state is Unfavorite
        // =========================================

        Assert.assertTrue(
                createdDashboardPage.isDashboardUnfavorite(),
                "Dashboard should initially be unfavorite"
        );

        pause();


        // =========================================
        // 6. Favorite Dashboard
        // =========================================

        createdDashboardPage.clickFavoriteButton();

        Assert.assertTrue(
                createdDashboardPage.isDashboardFavorite(),
                "Dashboard was not marked as favorite"
        );

        pause();


        // =========================================
        // 7. Un-Favorite Dashboard
        // =========================================

        createdDashboardPage.clickFavoriteButton();

        Assert.assertTrue(
                createdDashboardPage.isDashboardUnfavorite(),
                "Dashboard was not removed from favorites"
        );

        pause();
    }
}