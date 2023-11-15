package IOSTests;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import  Utilities.DriverUtilities;
import java.lang.reflect.Method;
import org.testng.annotations.*;

import static Utilities.AppiumUtilities.*;

public class BaseSetup {
    DriverUtilities driverUtilities;
    IOSDriver iosDriver;
    public BaseSetup() {
         driverUtilities=new DriverUtilities();
    }
    @BeforeClass
    public void beforeAll() {
        startAppiumServer();
    }

    @AfterClass
    public void afterAll() {
        stopAppiumServer();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        iosDriver = driverUtilities.createIOSAppiumDriver();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != iosDriver) {
            System.out.println("Close the driver");
            iosDriver.quit();
        }
    }
}
