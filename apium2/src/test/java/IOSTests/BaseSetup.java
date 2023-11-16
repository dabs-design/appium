package IOSTests;
import Utilities.ConfigUtils;
import io.appium.java_client.ios.IOSDriver;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import org.testng.annotations.*;

import static Utilities.AppiumServer.*;
import static Utilities.ConfigUtils.*;


public class BaseSetup {
    IOSDriver iosDriver;
    public BaseSetup() {

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
        ConfigUtils.loadConfProp("ios/ios.properties");
        iosDriver = ConfigUtils.getIOSDriver();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != iosDriver) {
            System.out.println("Close the driver");
            iosDriver.quit();
        }
    }
}
