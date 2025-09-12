package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FacilityNamePage extends BasePage {

    private static final By FacilityField_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.LinearLayout\").instance(4)"
    );
    private static final By Yes_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/yesButton\")"
    );

    public FacilityNamePage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(FacilityField_Locator); }

    public void enterFacilityName() { click(FacilityField_Locator); }

    public void tapYes() { click(Yes_BTN_Locator); }
}
