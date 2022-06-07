package com.cydeo.test.day_8_DropdownAlert;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDayDropdown {

    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {

//        1. Open Chrome browser
//        set up chrome and create WebDriver instance

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra time for our driver before it throws NoSuchElementException

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//               2. Go to https://practice.cydeo.com/dropdown

        driver.get("https://practice.cydeo.com/dropdown");

    }

//        3. Select “December 1st, 1923” and verify it is selected.

    @Test
    public void dateDropdownTest(){

        Select yearDropdown = new Select(driver.findElement(By.id("year")));

        Select monthDropdown = new Select(driver.findElement(By.id("month")));

        Select dayDropdown = new Select(driver.findElement(By.id("day")));


        yearDropdown.selectByVisibleText("1923");

        monthDropdown.selectByValue("11");

        dayDropdown.selectByIndex(0);

        String actualYearResult = yearDropdown.getFirstSelectedOption().getText();

        String expectedYearResult = "1923";

        Assert.assertEquals(actualYearResult, expectedYearResult);

        String actualMonthResult = monthDropdown.getFirstSelectedOption().getText();

        String expectedMonthResult = "December";

        Assert.assertEquals(actualMonthResult,expectedMonthResult);


        String actualDayResult = dayDropdown.getFirstSelectedOption().getText();

        String expectedDayResult = "1";

        Assert.assertEquals(actualDayResult,expectedDayResult);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





//    Select year using   : visible text
//    Select month using    : value attribute Select
//    day using : index number

}
