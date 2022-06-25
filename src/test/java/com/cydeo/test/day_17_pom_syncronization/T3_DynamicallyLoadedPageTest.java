package com.cydeo.test.day_17_pom_syncronization;

import com.cydeo.pages.DynamicallyLoadedPage7;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T3_DynamicallyLoadedPageTest {



    @Test
    public void dynamicallyLoad(){

//        1. Go to https://practice.cydeo.com/dynamic_loading/7

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        DynamicallyLoadedPage7 dynamicallyLoadedPage7 = new DynamicallyLoadedPage7();


//        2. Wait until title is “Dynamic title”

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

//        3. Assert: Message “Done!” is displayed.

        Assert.assertEquals(dynamicallyLoadedPage7.doneMsg.getText(),"Done!","Verification failed");

//        4. Assert: Image is displayed.

        Assert.assertTrue(dynamicallyLoadedPage7.image.isDisplayed());

    }

}
