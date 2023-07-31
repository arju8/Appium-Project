package com.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {
    @Test
    public void appiumFirstTest() throws MalformedURLException {

        //Create object of Android Driver to Automate Android apps
        //Appium client code> JSON wire protocol>Appium server>Virtual or physical Mobile Device
        //Start the appium server
        //Using UIAutomator2Options We can provide all the capabilities i.e which mobile, Android version and which application etc..
        //We need to add the appium server URl and the UiAutomator 2 options in the driver

        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Arjunan Emulator");
        options.setApp("C:\\Users\\Arjunan.ganesan\\Appium\\src\\test\\resources\\ApiDemos-debug.apk");
        AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.quit();
    }
}
