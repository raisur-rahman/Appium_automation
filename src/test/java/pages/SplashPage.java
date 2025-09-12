package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SplashPage extends BasePage {
    private static final By Logo_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/splashSimpleLogo\")"
    );
    private static final By Next_BTN_Locator = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.simple.clinic.staging:id/nextButton\")"
    );

    public SplashPage(AndroidDriver driver) { super(driver); }

    public boolean isLogoVisible() {
        try {
            return isVisible(Logo_Locator);
        } catch (Exception e) {
            System.out.println("❌ SplashPage not opened. Locator: " + Logo_Locator);
            System.out.println("📄 Page Source:\n" + driver.getPageSource().substring(0, 500));
            return false;
        }
    }

    public void tapOnNext(){
        click(Next_BTN_Locator);
    }
}
