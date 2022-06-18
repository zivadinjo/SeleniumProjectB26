package com.cydeo.test.day_14_driverUtil_javaFaker;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch_DriverPractice {

@Test
    public void google_search_driver_practice(){

//    Go to "https://www.google.com/"

    Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());


//    Write “apple” in search box

    WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
    System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
    searchBox.sendKeys("apple" + Keys.ENTER);

//    Verify title:
//    Expected:apple - Google Search

    String actualTitle = Driver.getDriver().getTitle();
    String expectedTitle = "apple - Google Search";
    System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

    Assert.assertEquals(actualTitle,expectedTitle);

    Driver.getDriver().quit();

    }
}
