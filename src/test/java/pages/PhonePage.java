package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PhonePage extends BasePage {
    private static final By PhoneField_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/phoneNumberEditText\")"
    );
    private static final By Next_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/nextButton\")"
    );

    public PhonePage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(PhoneField_Locator); }

    public void enterNumber(String number) { type(PhoneField_Locator, number); }

    public void tapOnNext() { click(Next_BTN_Locator); }
}
