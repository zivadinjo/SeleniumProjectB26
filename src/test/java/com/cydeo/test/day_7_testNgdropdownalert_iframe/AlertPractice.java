package com.cydeo.test.day_7_testNgdropdownalert_iframe;

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
//       Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to website: http://practice.cydeo.com/javascript_alerts

        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void InfoAlertTest() {


//        3. Click to “Click for JS Alert” button

        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

//        4. Click to OK button from the alert
//      driver.switchTo().accept();
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        5. Verify “You successfully clicked an alert” text is displayed.

        WebElement resultTxt = driver.findElement(By.id("result"));
        Assert.assertTrue(resultTxt.isDisplayed());

        String actualRes = resultTxt.getText();
        String expectedRes = "You successfully clicked an alert";

        Assert.assertEquals(actualRes,expectedRes,"Result text did not appear correctly ");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
