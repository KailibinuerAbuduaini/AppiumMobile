package com.automation.tests.day02;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class CloudTesting {

    public static String userName="kalbinurgheni1";
    public static String accessKey="8cM9orqfUWQuzmQdocVd";
    //instead of connecting to the localhost, we gonna connect to the browserstack server
    //that server, has access to lots of real phones
    //By doing this, we don't need appium server or emulator in our computer
    //appium server and device is on cloud, we don't need local one.

    public static String URL="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
    private AppiumDriver driver;


    //my etsy account
    private String email = "kdelightful103@gmail.com";
    private String password = "z7v8tcm889966";


    @Test
    public void test1() throws Exception {
        //these capabilities are specific to browserstack
        //you will not use them when you would try to connect to the appium server directly
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("device", "Google Pixel 3 XL");
        desiredCapabilities.setCapability("os_version", "9.0");
        desiredCapabilities.setCapability("project", "Calculator");
        desiredCapabilities.setCapability("build", "My First Build");
        desiredCapabilities.setCapability("name", "Calculator Test");
        //app is a parameter that is used to specify application for testing
        //when you are connecting to appium server, it's just enough to specify path to the app
        //with browserstack - it doesn't work like this
        //to make it work, we need to upload app on our account first, then we will be able to test it
        //break 10 minutes
        desiredCapabilities.setCapability("app", "bs://aa3bc99f74dbabc01ea98679fd6af1f709f1fffc");
        driver = new AndroidDriver(new URL(URL), desiredCapabilities);

        //the biggest problem of selenium is synchronization.
        //basically, it doesn't wait
        //if element will delay to appear, you will get NoSuchElementException
        //to prevent this issue, we can use explicit wait
        //don't use explicit and implicit waits together!
        //how to use explicit wait in appium?
        //in the same way like in selenium
        WebDriverWait wait = new WebDriverWait(driver, 15);

       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.etsy.android:id/btn_link")));

        WebElement getStarted=driver.findElement(By.id("com.etsy.android:id/btn_link"));


     getStarted.click();

        //username input box
        WebElement usernameElement = driver.findElementById("com.etsy.android:id/edit_username");
        //password input box
        WebElement passwordElement = driver.findElementById("com.etsy.android:id/edit_password");
        //sign in button
        WebElement signinElement = driver.findElementById("com.etsy.android:id/button_signin");

        usernameElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signinElement.click();

        Thread.sleep(5000);
        driver.closeApp();



    }

}
