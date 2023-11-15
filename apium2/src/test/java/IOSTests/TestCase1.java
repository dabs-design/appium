package IOSTests;
import IOS.Pages.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;



public class TestCase1 extends BaseSetup{
    BasePage basePage;

    public TestCase1() {
     basePage=new BasePage(super.iosDriver);


    }


    @Test(testName = "Mybasic test")
    public void emailClick(){
        basePage.emailClick();
    }
}
