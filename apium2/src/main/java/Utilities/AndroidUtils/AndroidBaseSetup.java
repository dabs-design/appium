package Utilities.AndroidUtils;
import Utilities.CommonUtils.ConfigUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import org.testng.annotations.*;

import static Utilities.CommonUtils.AppiumServer.*;


public class AndroidBaseSetup {
    AndroidDriver androidDriver;
    public AndroidBaseSetup() {

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
