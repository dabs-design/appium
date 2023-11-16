package IOS.Pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.FindBy;

public class Navigate extends  PageObject {

        public Navigate(IOSDriver driver) {

            super(driver);
        }

        @FindBy(xpath="//XCUIElementTypeButton[@name=\"Fun Facts\"]")
        private WebElement funFacts;

        @FindBy(xpath="//XCUIElementTypeButton[@name=\"Home\"]")
        private WebElement home;

        @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Favorites\"]")
        private WebElement favorite;

        @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Story\"]")
        private WebElement story;



        public void storyClick(){
            story.click();
        }

        public void favoriteClick(){
            favorite.click();
        }

        public void homeClick(){
            home.click();
        }
        public void funFactsClick(){
            funFacts.click();
        }

}
