package IOS.Pages;

import Utilities.CommonUtils.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSDriver;

public class Navigate extends PageObject {

        public Navigate(IOSDriver iosDriver) {

            super(iosDriver);
        }

        public static By funFacts=By.xpath("//XCUIElementTypeButton[@name=\"Fun Facts\"]");

        public static By home =By.xpath("//XCUIElementTypeButton[@name=\"Home\"]");

        public  static By favorite=By.xpath("//XCUIElementTypeButton[@name=\"Favorites\"]");

        public  static  By storyElement=By.xpath("//XCUIElementTypeButton[@name=\"Story\"]");
        public WebElement getStoryElement() {
            return iosDriver.findElement(storyElement);
        }

        public  WebElement getFunFactsElement() {
             return iosDriver.findElement(funFacts);
        }

        public  WebElement getHomeElement() {
            return iosDriver.findElement(home);
        }

        public  WebElement getFavoriteElement() {
            return iosDriver.findElement(favorite);
        }




}
