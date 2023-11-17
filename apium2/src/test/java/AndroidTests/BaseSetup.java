package AndroidTests;
import Utilities.ConfigUtils;
import com.beust.ah.A;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import org.testng.annotations.*;

import static Utilities.AppiumServer.*;
import static Utilities.ConfigUtils.*;


public class BaseSetup {
    AndroidDriver androidDriver;
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
        ConfigUtils.loadConfProp("android/android.properties");
        androidDriver = ConfigUtils.getAndroidDriver();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != androidDriver) {
            System.out.println("Close the driver");
            androidDriver.quit();
        }
    }
}
