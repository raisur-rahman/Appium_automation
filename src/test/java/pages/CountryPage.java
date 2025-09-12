package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CountryPage extends BasePage {

    private static final By Options_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/countryListContainer\")");

    public CountryPage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() { return isVisible(Options_Locator); }

    public void selectCountry(String countryName) {
        By countryLocator = By.xpath(
                "//android.widget.RadioButton[@resource-id=\"org.simple.clinic.staging:id/countryButton\" and @text=\"" + countryName + "\"]"
        );
        click(countryLocator);
    }
}
