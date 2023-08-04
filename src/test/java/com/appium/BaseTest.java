package com.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.CommandExecutionHelper.executeScript;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;


        @BeforeClass
        public void configureAppium() throws MalformedURLException {

            //Create object of Android Driver to Automate Android apps
            //Appium client code> JSON wire protocol>Appium server>Virtual or physical Mobile Device
            //Start the appium server
            //Using UIAutomator2Options We can provide all the capabilities i.e which mobile, Android version and which application etc..
            //We need to add the appium server URl and the UiAutomator 2 options in the driver

             service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Arjunan.ganesan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();  //Appiumservice builder is responsible for starting and stopping the server  we need to give the path of main.js file

            service.start();//start the appium service

            UiAutomator2Options options=new UiAutomator2Options();
            options.setDeviceName("Pixel_3a_API_34_extension_level_7_x86_64");
            options.setApp("C:\\Users\\Arjunan.ganesan\\Appium\\src\\test\\resources\\ApiDemos-debug.apk");
             driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        }

    public void longClickGesture(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "duration",3000));

    }

//    public void scrollGetsureUsingAndroidUIAutomator(String text){
//            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"text\"));"));
//    }

public void scrollGestureMethod()  {
    boolean canScrollMore;
            do {

     canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
            "left", 100, "top", 100, "width", 200, "height", 200,
            "direction", "down",
            "percent", 1.0
    ));


            }
            while (canScrollMore);

    System.out.println(canScrollMore);
}

public void swipeGesture(WebElement ele){
    ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
    "direction","left",
            "percent",1.0
    ));
}
        @AfterClass
        public void tearDown(){
            driver.quit();

            service.stop(); //stop the appium service
        }

        //Gallery
    //1. Photos
    //android.widget.Gallery/android.widget.ImageView[1]

}
