package com.cydeo.test.day_7_TestNgdropdownalert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_State_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

//        1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//       Providing extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void stateDropdown() {

        Select stateDropdown = new Select(driver.findElement(By.id("state")));
//        3. Select Illinois
        stateDropdown.selectByValue("IL");

//        4. Select Virginia
        stateDropdown.selectByVisibleText("Virginia");

//        5. Select California
        stateDropdown.selectByIndex(5);

//        6. Verify final selected option is California.
//        getFirstSelectedOption()=> will return current selected option
        String actualDrop = stateDropdown.getFirstSelectedOption().getText();
        String expectedDrop = "California";
        Assert.assertEquals(actualDrop, expectedDrop);

//        Use all Select options. (visible text, value, index)

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
