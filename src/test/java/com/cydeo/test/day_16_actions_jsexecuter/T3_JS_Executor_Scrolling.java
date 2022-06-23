package com.cydeo.test.day_16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_JS_Executor_Scrolling {

    @Test
    public void etsy_scroll_test(){

         //* Go to Etsy homepage
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));

         //* Scroll down
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//        js.executeScript("window.scrollBy(0, 5000)");
        WebElement email = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)",email);

         //* Generate random email and enter into subscribe box
        Faker faker = new Faker();
        email.sendKeys(faker.internet().emailAddress());

         //* Click on Subscribe
        WebElement subscribeBtn = Driver.getDriver().findElement(By.xpath("//button[@class='wt-btn wt-input-btn-group__btn']"));
        subscribeBtn.click();

//        email.sendKeys(faker.internet().emailAddress())+Keys.ENTER); -> second way to click subscribe button

         //*Verify "Great! We've sent you an email to confirm your subscription." is displayed
        WebElement result = Driver.getDriver().findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        String actual = result.getText();
        String expected = "Great! We've sent you an email to confirm your subscription.";

        Assert.assertEquals(actual,expected,"Verification failed");

    }

}
