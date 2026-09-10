package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ListenerFailureTest extends BaseTest {

    @Test(groups = {"debug"})
    public void verifyScreenshotOnFailure() {

        pause();

        Assert.fail(
                "Intentional failure to verify screenshot listener"
        );
    }
}