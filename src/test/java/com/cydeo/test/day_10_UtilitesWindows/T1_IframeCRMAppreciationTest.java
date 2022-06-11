package com.cydeo.test.day_10_UtilitesWindows;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_IframeCRMAppreciationTest {
// Failed for many reasons
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sendingAppreciationMsg() {

//        2- Go to: https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

//        3- Login Homepage ( Login with valid username:helpdesk1@cybertekschool.com and password:UserUser)
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();


//        4- Click the MORE tab and select APPRECIATION
        WebElement moreBtn = driver.findElement(By.xpath("//span[contains(@id,'link-text')]"));// cssSelector: span[id*='link-text']
        moreBtn.click();

        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

//        5- Write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Cao!");


//        6- Click the SEND button

        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();


//        7- Verify the Appreciation message is displayed on the feed

        WebElement feedText = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        String actualText = feedText.getText();
        String expectedText = "Cao!";

        Assert.assertEquals(actualText,expectedText,"Verification failed");

    }

        @AfterMethod
        public void tearDown() {
            driver.quit();
    }
}
