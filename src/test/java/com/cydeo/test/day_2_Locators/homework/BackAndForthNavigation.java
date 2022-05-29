package com.cydeo.test.day_2_Locators.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {
    public static void main(String[] args) throws InterruptedException {

        /*
        TC #3: Back and forth navigation
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Click to Gmail from top right.
        4- Verify title contains:
            Expected: Gmail
        5- Go back to Google by using the .back();
        6- Verify title equals:
            Expected: Google
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement gmail = driver.findElement(By.className("gb_d"));
        gmail.sendKeys(Keys.ENTER);

        String expectedTittle = "Gmail";
        String actualTittle = driver.getTitle();
        if (actualTittle.contains(expectedTittle)){
            System.out.println("Verification for gmail passed");
        }else {
            System.out.println("Verification for gmail failed");
        }


        driver.navigate().back();


        String expectedTittle1 = "Google";
        String actualTittle1 = driver.getTitle();
        if (actualTittle1.equals(expectedTittle1)){
            System.out.println("Verification for google passed");
        }else {
            System.out.println("Verification for google failed");
        }

        driver.quit();



    }
}
