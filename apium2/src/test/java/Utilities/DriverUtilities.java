package Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static Utilities.AppiumUtilities.getAppiumServerUrl;
public class DriverUtilities {
    public IOSDriver createIOSAppiumDriver() {
        // Appium 1.x
        // DesiredCapabilities dc = new DesiredCapabilities();
        // Appium 2.x

        XCUITestOptions dc = new XCUITestOptions();
        dc.setPlatformVersion("");
        dc.setUdid("");
        dc.setDeviceName("");
        dc.setAutomationName("");
            return new IOSDriver(getAppiumServerUrl(), dc);
    }
}
