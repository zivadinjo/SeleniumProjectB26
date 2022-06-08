package com.cydeo.test.day_8_DropdownAlert;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //        1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }
    @Test
    public void confirmAlertTest(){

//        3. Click for JS Confirm button

        WebElement confirmAlertBtn = driver.findElement((By.xpath("//button[@onclick='jsConfirm()']")));
        confirmAlertBtn.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.

        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You clicked: Ok";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void promtAlertTest(){

//        3. Click to “Click for JS Prompt” button

        WebElement jsPromt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromt.click();

//        4. Send “hello” text to alert

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

//        5. Click to OK button from the alert

        alert.accept();

//        6. Verify “You entered:  hello” text is displayed.

        String  actualAlertResult =  driver.findElement(By.id("result")).getText();
        String expectedAlertResult = "You entered: hello";

        Assert.assertEquals(actualAlertResult, expectedAlertResult,"Result did not appear correctly");


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
