package Utilities.IOSUtils;
import Utilities.CommonUtils.ConfigUtils;
import io.appium.java_client.ios.IOSDriver;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import org.testng.annotations.*;

import static Utilities.CommonUtils.AppiumServer.*;


public class IOSBaseSetup {
    public IOSDriver iosDriver;
    public IOSUtilities iosUtilities;
    public IOSBaseSetup() {

    }


    public IOSDriver getDriver(){
        return this.iosDriver;
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
        iosUtilities=new IOSUtilities(iosDriver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != iosDriver) {
            System.out.println("Close the driver");
            iosDriver.quit();
        }
    }
}
