package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By HomeTitle_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().description(\"Patients\")"
    );

    public MainPage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(HomeTitle_Locator); }
}
