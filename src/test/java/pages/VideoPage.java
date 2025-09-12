package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class VideoPage extends BasePage {
    private static final By Skip_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/skipButton\")"
    );

    public VideoPage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(Skip_BTN_Locator); }

    public void tapOnSkip() { click(Skip_BTN_Locator); }
}
