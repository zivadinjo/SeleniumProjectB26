package com.cydeo.test.day_10_UtilitesWindows;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_WindowsHandle extends TestBase {

    @Test
    public void windowHandleTest() {

//        2. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

//        3. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle, "Main window title Verification failed");

//        4. Click to: “Click Here” link
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();


//        5. Switch to new Window.
        Set <String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("driver get title "+driver.getTitle());


        }


//        6. Assert: Title is “New Window”

        String actualNewWindow = driver.getTitle();
        String expectedNewWindow = "New Window";

        Assert.assertEquals(actualNewWindow,expectedNewWindow,"Verification failed");
    }

}
