package tests;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class LaunchAppTest extends BaseTest {

    @Test
    public void testLaunchApp() {
        verifySplashPageOpened();
    }

    @Step("Verify Splash Page is opened")
    private void verifySplashPageOpened() {
        SplashPage splashPage = new SplashPage(driver);
        Assert.assertTrue(splashPage.isLogoVisible(), "Splash Page did not open.");
    }
}
