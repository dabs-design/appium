package Utilities.IOSUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Objects;

public  class IOSUtilities {
    IOSDriver driver;

    public IOSUtilities(IOSDriver driver) {
        this.driver = driver;
    }

    public void click(By element){
        driver.findElement(element).click();
    }
    public static void click(IOSDriver iosDriver, By element){
        iosDriver.findElement(element).click();
    }
    public static void click(WebElement element){
        element.click();
    }

    public static void enterText(WebElement element,String text){
        element.sendKeys(text);
    }
    public void enterText(By element,String text){
        driver.findElement(element).sendKeys(text);
    }
    public static void enterText(IOSDriver driver,By element,String text){
        driver.findElement(element).sendKeys(text);
    }
    public static void clickVolumeUP(IOSDriver driver,int count){
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
        }
    }
    public  void clickVolumeUP(int count){
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
        }
    }
    public static void clickVolumeUPWithWait(IOSDriver driver,int count,long waitTimeInMilliSec) throws InterruptedException {
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
            driver.wait(waitTimeInMilliSec);
        }
    }
    public  void clickVolumeUPWithWait(int count,long waitTimeInMilliSec) throws InterruptedException {
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
            driver.wait(waitTimeInMilliSec);
        }
    }
    public static void clickVolumeDown(IOSDriver driver,int count){
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));
        }
    }
    public void clickVolumeDown(int count){
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));
        }
    }
    public static void clickVolumeDownWithWait(IOSDriver driver,int count,long waitTimeInMilliSec) throws InterruptedException {
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));
            driver.wait(waitTimeInMilliSec);
        }
    }

    public void clickVolumeDownWithWait(int count,long waitTimeInMilliSec) throws InterruptedException {
        for(int i=0;i<count;i++){
            driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));
            driver.wait(waitTimeInMilliSec);
        }
    }

    public static void goHome(IOSDriver driver){
        driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
    }
    public void goHome(){
        driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
    }

    public static void waitMilli(IOSDriver driver,long timeInMilliSec) throws InterruptedException {
        driver.wait(timeInMilliSec);
    }
    public void waitMilli(long timeInMilliSec) throws InterruptedException {
        driver.wait(timeInMilliSec);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenShot(IOSDriver driver){
        try{
        byte[] scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);


            return scrFile;
        }
        catch (Exception e)
        {
            System.err.println("Couldn't write to file...");
            return new byte[]{};
        }

    }
}
