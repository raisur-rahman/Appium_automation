package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NamePage extends BasePage {
    private static final By NameField_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/fullNameEditText\")"
    );
    private static final By Next_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/nextButton\")"
    );

    public NamePage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(NameField_Locator); }

    public void enterName(String name) { type(NameField_Locator, name); }

    public void tapOnNext() { click(Next_BTN_Locator); }
}
