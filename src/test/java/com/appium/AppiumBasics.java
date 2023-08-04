package com.appium;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.net.MalformedURLException;


public class AppiumBasics extends BaseTest{


    @Test
    @Ignore
    public void appiumFirstWiFiTest() throws MalformedURLException {
         driver.findElement(AppiumBy.accessibilityId("Preference")).click();
         driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
         driver.findElement(By.id("android:id/checkbox")).click();
         driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
         String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
         Assert.assertEquals(alertTitle,"WiFi settings");
         driver.findElement(By.id("android:id/edit")).sendKeys("Arjunan WiFi");



    }

    //appium mobile gestures
    @Test
    @Ignore
    public void longClickGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement longC=driver.findElement(By.xpath("//android.widget.ExpandableListView/android.widget.TextView[1]"));

        longClickGesture(longC);


       Thread.sleep(2000);


    }


    @Test
    @Ignore
    public void scrollGestureWithAndroiUiAutomator(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //use this if you know the element
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }

    @Test
    @Ignore
    public void scrollGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        scrollGestureMethod();


    }

    @Test
    public  void swipe() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        System.out.println("clicked");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Gallery']")).click();
        System.out.println("clicked");
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        System.out.println("clicked");
        WebElement pic=driver.findElement(AppiumBy.xpath("//android.widget.Gallery/android.widget.ImageView[1]"));
        String attribute=driver.findElement(AppiumBy.xpath("//android.widget.Gallery/android.widget.ImageView[1]")).getAttribute("focusable");
        Assert.assertEquals(attribute,"true");

        Thread.sleep(2000);
        swipeGesture(pic);
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.Gallery/android.widget.ImageView[1]")).getAttribute("focusable"),"false");


    }
}
