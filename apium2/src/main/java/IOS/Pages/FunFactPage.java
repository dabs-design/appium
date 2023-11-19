package IOS.Pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FunFactPage extends Navigate{
    public FunFactPage(IOSDriver driver) {
        super(driver);
    }




    private static final By showRandomFact=By.xpath("//XCUIElementTypeButton[@name=\"Show Random Fact\"]");
    public WebElement getShowRandomFact() {
        return iosDriver.findElement(showRandomFact);

    }



}
