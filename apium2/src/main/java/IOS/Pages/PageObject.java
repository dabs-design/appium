package IOS.Pages;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class PageObject {
    protected IOSDriver driver;

    public PageObject(IOSDriver driver) {
        this.driver = driver;
       PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }
}
