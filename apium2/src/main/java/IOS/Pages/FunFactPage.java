package IOS.Pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FunFactPage extends Navigate{
    public FunFactPage(IOSDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//XCUIElementTypeButton[@name=\"Show Random Fact\"]")
    private WebElement showRandomFact;

    public void showRandomFactClick(){
        showRandomFact.click();
    }


}
