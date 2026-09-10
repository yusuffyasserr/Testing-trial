package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ListenerFailureTest extends BaseTest {

    @Test(groups = {"debug"})
    public void verifyScreenshotOnFailure() {

        pause();

        Assert.fail(
                "Intentional failure to verify screenshot listener"
        );
    }
}