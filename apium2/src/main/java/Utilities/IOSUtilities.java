package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;

public  class IOSUtilities {

    public static void clickVolumeUP(IOSDriver iosDriver,int count){
        for(int i=0;i<count;i++){
        iosDriver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
        }
    }
    public static void clickVolumeUPWithWait(IOSDriver iosDriver,int count,long waitTimeInMilliSec) throws InterruptedException {
        for(int i=0;i<count;i++){
            iosDriver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
            iosDriver.wait(waitTimeInMilliSec);
        }
    }

    public static void clickVolumeDown(IOSDriver iosDriver,int count){
        for(int i=0;i<count;i++){
            iosDriver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));
        }
    }
    public static void clickVolumeDownWithWait(IOSDriver iosDriver,int count,long waitTimeInMilliSec) throws InterruptedException {
        for(int i=0;i<count;i++){
            iosDriver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));
            iosDriver.wait(waitTimeInMilliSec);
        }
    }

    public static void goHome(IOSDriver iosDriver){
            iosDriver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
    }

}
