package com.cydeo.test.day_11_WebtablesUtilities;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_WebtablePractice extends TestBase {

    @Test
    public void order_name_verify_test(){

//        1. Goto : https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

//        2. Verify Bob’s name is listed as expected.
//        Expected: “Bob Martin”

        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actualResult = bobMartinCell.getText();
        String expectedResult = "Bob Martin";

        Assert.assertEquals(actualResult,expectedResult,"Verification of Bob Martin listing failed");

//        3. Verify Bob Martin’s order date is as expected
//        Expected: 12/31/2021

        WebElement date = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='12/31/2021']"));

        String actualDate = date.getText();
        String expectedDate = "12/31/2021";

        Assert.assertEquals(actualDate,expectedDate,"Date verification failed");

    }

}
