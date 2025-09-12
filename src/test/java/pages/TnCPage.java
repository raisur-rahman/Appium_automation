package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TnCPage extends BasePage {
    private static final By Agree_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.Button\")");

    public TnCPage(AndroidDriver driver) { super(driver); }

    public boolean isPageOpened() {
        try {
            return isVisible(Agree_BTN_Locator);
        } catch (Exception e) {
            System.out.println("❌ TnCPage not opened. Locator: " + Agree_BTN_Locator);
            System.out.println("📄 Page Source:\n" + driver.getPageSource().substring(0, 500));
            return false;
        }
    }

    public void acceptTnC() { click(Agree_BTN_Locator); }
}
