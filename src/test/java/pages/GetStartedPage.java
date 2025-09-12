package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class GetStartedPage extends BasePage {
    private static final By GetStarted_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/getStartedButton\")");

    public GetStartedPage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(GetStarted_BTN_Locator); }

    public void tapOnGetStarted() { click(GetStarted_BTN_Locator); }
}
