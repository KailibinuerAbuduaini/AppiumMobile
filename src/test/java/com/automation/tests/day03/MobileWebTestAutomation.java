package com.automation.tests.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileWebTestAutomation {

    private RemoteWebDriver driver;
    @Test
    public void test1() throws Exception {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID);

        desiredCapabilities.setCapability("platformVersion", "7.0");

        desiredCapabilities.setCapability("deviceName", "Pixel_2");


        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(5000);

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password", Keys.ENTER);


        Thread.sleep(5000);
        driver.quit();


    }

}
