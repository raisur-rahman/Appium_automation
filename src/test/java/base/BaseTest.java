package base;

import config.CapabilitiesConfig;
import config.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    protected AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) throws Exception {
        // Load from JSON (provide default path if you want)
        // e.g., -Denv=env/local.android.json
        CapabilitiesConfig cfg = ConfigLoader.load("env/local.android.json");

        UiAutomator2Options opts = new UiAutomator2Options();
        opts.setPlatformName(cfg.platformName != null ? cfg.platformName : "Android");
        opts.setAutomationName(cfg.automationName != null ? cfg.automationName : "UiAutomator2");
        opts.setDeviceName(cfg.deviceName);
        if (cfg.udid != null) opts.setUdid(cfg.udid);
        if (cfg.app != null)  opts.setApp(cfg.app);

        int nct = cfg.newCommandTimeoutSec != null ? cfg.newCommandTimeoutSec : 180;
        opts.setNewCommandTimeout(Duration.ofSeconds(nct));

        // raw caps (works across java-client versions)
        if (cfg.autoGrantPermissions != null) {
            opts.setCapability("autoGrantPermissions", cfg.autoGrantPermissions);
        }
        if (cfg.autoAcceptAlerts != null) {
            opts.setCapability("autoAcceptAlerts", cfg.autoAcceptAlerts);
        }

        String server = (cfg.appiumServer != null) ? cfg.appiumServer : "http://127.0.0.1:4723/";
        driver = new AndroidDriver(new URL(server), opts);
        context.setAttribute("driver", driver);

        new File(System.getProperty("user.dir") + "/screenshots").mkdirs();
    }

    @AfterMethod(alwaysRun = true)
    public void attachScreenshotOnFailure(ITestResult result) {
        if (driver == null) return;
        if (result.getStatus() != ITestResult.FAILURE) return;

        String method = result.getMethod().getMethodName();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = method + "-" + timestamp + "-screenshot.png";
        String localPath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(method + " (screenshot)", new ByteArrayInputStream(png));
            Files.write(new File(localPath).toPath(), png);
            Allure.addAttachment("Saved to", new ByteArrayInputStream(localPath.getBytes()));
        } catch (Throwable t) {
            System.err.println("Failed to capture/attach screenshot: " + t.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
