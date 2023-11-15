package IOS.Pages;

import io.appium.java_client.pagefactory.iOSBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSDriver;

    public class BasePage extends  PageObject {

        public BasePage(IOSDriver driver) {
            super(driver);
        }

        @iOSBy(xpath="com.sourcey.materialloginexample:id/input_email")
        private WebElement email;


        public void emailClick(){
            email.click();
        }



}
