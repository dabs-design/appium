package Utilities.CommonUtils;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class PageObject {
    //Common for both IOS and Android
    public AndroidDriver androidDriver;
    public IOSDriver iosDriver;

    public PageObject(AndroidDriver driver) {
        this.androidDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);

    }
    public PageObject(IOSDriver driver) {
        this.iosDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.iosDriver), this);

    }

}
