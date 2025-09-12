package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ConfirmPinPage extends BasePage {
    private static final By ConfirmPinField_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/confirmPinEditText\")"
    );

    public ConfirmPinPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isVisible(ConfirmPinField_Locator);
    }

    public void confirmPIN(String pin) {
        type(ConfirmPinField_Locator, pin);
    }
}
