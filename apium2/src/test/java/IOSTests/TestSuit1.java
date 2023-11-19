package IOSTests;

import IOS.Pages.FunFactPage;
import Utilities.IOSUtils.IOSBaseSetup;
import Utilities.IOSUtils.IOSUtilities;
import Utilities.Log.Log;
import Utilities.ReportUtils.Listeners.AllureTestNgListenerIOS;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static Utilities.ReportUtils.Listeners.AllureTestNgListenerIOS.*;

@Listeners({ AllureTestNgListenerIOS.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class TestSuit1  extends IOSBaseSetup {


    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void testcase1(){


        FunFactPage funFactPage =new FunFactPage(iosDriver);
        IOSUtilities.click(funFactPage.getStoryElement());
        IOSUtilities.click(funFactPage.getFunFactsElement());
        iosUtilities.goHome();
    }


    @Test(priority = 1, description = " Login Scenario with  username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with  username and  password.")
    @Story(" username and password login test")
    public void testcase2(){


        Log.allureLog("Started test");
        FunFactPage funFactPage =new FunFactPage(iosDriver);


        Log.allureLog("1 getting WebElement and passing to iosActions");
        IOSUtilities.click(funFactPage.getFunFactsElement());

        Log.allureLog("2 getting By and passing to iosActions");
        iosUtilities.click(FunFactPage.funFacts);
        IOSUtilities.click(iosDriver, FunFactPage.funFacts);



        Log.allureLog("3 getting WebElement and doing click operation directly");
        funFactPage.getFunFactsElement().click();
        IOSUtilities.takeScreenShot(iosDriver);
        IOSUtilities.click(funFactPage.getStoryElement());
        iosUtilities.goHome();



    }
}

