package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreatePinPage extends BasePage {
    private static final By PinField_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/pinEditText\")"
    );

    public CreatePinPage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(PinField_Locator); }

    public void createPIN(String pin) { type(PinField_Locator, pin); }
}
