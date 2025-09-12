package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ClinicPage extends BasePage {

    private static final By ClinicTitle_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.view.ViewGroup\").instance(1)"
    );

    public ClinicPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isVisible(ClinicTitle_Locator);
    }

    public void selectClinicLocation(String clinicName) {
        By clinicLocator = AppiumBy.xpath(
                "//android.widget.RadioButton[@resource-id='org.simple.clinic.staging:id/stateRadioButton' and @text='" + clinicName + "']"
        );
        click(clinicLocator);
    }
}
