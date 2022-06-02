package com.cydeo.test.day_6_TestNG_StaleElement;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_StaleElementExample {
    public static void main(String[] args) {

//        TC #1: StaleElementReferenceException handling
//        1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


//        2. Go to https://practice.cydeo.com/add_remove_elements/

        driver.get("https://practice.cydeo.com/add_remove_elements/");

//        3. Click to “Add Element” button

        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();

//        4. Verify “Delete” button is displayed after clicking

        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));

//        5. Click to “Delete” button.

        deleteButton.click();

//        6. Verify “Delete” button is NOT displayed after clicking.

//       System.out.println("deleteButton is Displayed = " + deleteButton.isDisplayed());

        try {
            System.out.println("deleteButton is Displayed = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("Web element is completely deleted from page");
        }

        driver.quit();


    }
}
