package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static Utilities.AppiumServer.getAppiumServerUrl;


public class ConfigUtils {
    private static final XCUITestOptions xcuiTestOptions = new XCUITestOptions();
    private static final Properties prop = new Properties();
    public static int EXPLICIT_WAIT_TIME;
    private static String APPIUM_PORT;
    private static int IMPLICIT_WAIT_TIME;
    private static String BASE_PKG;
    private static String APP_ACTIVITY;
    private static String APP_PATH;
    private static String BROWSER_NAME;
    private static String PLATFORM_NAME;
    private static String PLATFORM_VERSION;
    private static String DEVICE_NAME;
    private static String UDID;
    private static String BUNDLE_ID;
    private static String XCODE_SIGNING_ID;
    private static FileInputStream fis;
    //public static TestConfigUtils testConfig =new TestConfigutils();
    private static String XCODE_ORG_ID;
    private static String AUTOMATION_NAME;

    public static void loadConfProp(String loadPropertyFile) {

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/" + loadPropertyFile);
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong (FileNotFound for file " + loadPropertyFile);
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Something went wrong (Loading Properties file): ");
            e.printStackTrace();
        }
        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait","0"));
        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait","0"));
        BROWSER_NAME = prop.getProperty("browser.name",null);
        PLATFORM_NAME = prop.getProperty("platform.name",null);
        PLATFORM_VERSION = prop.getProperty("platform.version",null);
        DEVICE_NAME = prop.getProperty("device.name",null);
        BUNDLE_ID = prop.getProperty("bundle.id",null);
        XCODE_SIGNING_ID = prop.getProperty("xcodeSigning.id",null);
        XCODE_ORG_ID = prop.getProperty("xcodeOrd.id",null);
        AUTOMATION_NAME = prop.getProperty("automation.name",null);
        UDID = prop.getProperty("udid",null);
        //APPIUM_PORT = prop.getProperty("appium.server.port");

    }


    public static AndroidDriver getAndroidDriver() {
        try {
            UiAutomator2Options dc = new UiAutomator2Options();
            dc.setPlatformVersion(PLATFORM_VERSION);
            if(UDID!=null && !UDID.isEmpty() && !UDID.isBlank())dc.setUdid(UDID);
            if(DEVICE_NAME!=null&& !DEVICE_NAME.isEmpty() && !DEVICE_NAME.isBlank())dc.setDeviceName(DEVICE_NAME);
            if(AUTOMATION_NAME!=null&& !AUTOMATION_NAME.isEmpty() && !AUTOMATION_NAME.isBlank())dc.setAutomationName(AUTOMATION_NAME);
            dc.setChromedriverExecutable(System.getProperty("user.dir") + "\\src&&test\\resources\\drivers\\chromedriver.exe");
            return new AndroidDriver(getAppiumServerUrl(), dc);
        } catch (Exception e) {
            System.out.println("Something went wrong (Loading Android Driver)");
            e.printStackTrace();
            throw e;
        }


    }


    public static IOSDriver getIOSDriver() {
        try {
            XCUITestOptions dc = new XCUITestOptions();
            if(PLATFORM_VERSION!=null&& !PLATFORM_VERSION.isEmpty() && !PLATFORM_VERSION.isBlank())dc.setPlatformVersion(PLATFORM_VERSION);
            if(UDID!=null && !UDID.isEmpty() && !UDID.isBlank())dc.setUdid(UDID);
            if(DEVICE_NAME!=null&& !DEVICE_NAME.isEmpty() && !DEVICE_NAME.isBlank())dc.setDeviceName(DEVICE_NAME);
            if(AUTOMATION_NAME!=null&& !AUTOMATION_NAME.isEmpty() && !AUTOMATION_NAME.isBlank())dc.setAutomationName(AUTOMATION_NAME);
            if(true)dc.showXcodeLog();
            if(XCODE_SIGNING_ID!=null&& !XCODE_SIGNING_ID.isEmpty() && !XCODE_SIGNING_ID.isBlank())dc.setCapability(XCUITestOptions.XCODE_SIGNING_ID_OPTION, XCODE_SIGNING_ID);
            if(XCODE_ORG_ID!=null&& !XCODE_ORG_ID.isEmpty() && !XCODE_ORG_ID.isBlank())dc.setCapability(XCUITestOptions.XCODE_ORG_ID_OPTION, XCODE_ORG_ID);
            if(BUNDLE_ID!=null&& !BUNDLE_ID.isEmpty() && !BUNDLE_ID.isBlank())dc.setBundleId(BUNDLE_ID);


            return new IOSDriver(getAppiumServerUrl(), dc);
        } catch (Exception e) {
            System.out.println("Something went wrong (Loading IOS Driver)");
            e.printStackTrace();
            throw e;
        }

    }

}
