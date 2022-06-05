package com.cydeo.test.day_7_TestNgdropdownalert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
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


    @Test
    public void multiSelectDropdowntest(){


//        3. Select all the options from multiple select dropdown.

        Select languages = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));

        System.out.println("languages.isMultiple() = " + languages.isMultiple());

//       getOptions() will return to all options in dropdown
        List<WebElement> allOptions = languages.getOptions();

//        languages.selectByValue("java");
//        languages.selectByVisibleText("C#");
//        languages.selectByIndex(3);

//        4. Print out all selected values.

        for (WebElement each : allOptions) {

            each.click();
            System.out.println("each.getText() "+each.getText());


        }

//        5. Deselect all values.

        languages.deselectAll();


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
