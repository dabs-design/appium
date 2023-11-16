package IOSTests;

import IOS.Pages.FunFactPage;
import IOS.Pages.Navigate;
import org.testng.annotations.Test;

import static Utilities.IOSUtilities.*;

public class TestSuit1  extends BaseSetup{

    public TestSuit1() {

    }


    @Test(testName = "my first Test")
    public void testcase1(){
        FunFactPage funFactPage =new FunFactPage(super.iosDriver);
        funFactPage.storyClick();
        funFactPage.favoriteClick();
        funFactPage.funFactsClick();
        funFactPage.homeClick();
        funFactPage.funFactsClick();
        funFactPage.showRandomFactClick();
        clickVolumeUP(super.iosDriver,1);

    }


    @Test(testName = "my second Test")
    public void testcase2(){
        FunFactPage funFactPage =new FunFactPage(super.iosDriver);
        funFactPage.storyClick();
        funFactPage.favoriteClick();
        funFactPage.funFactsClick();
        funFactPage.homeClick();
        funFactPage.funFactsClick();
        funFactPage.showRandomFactClick();

    }
}

