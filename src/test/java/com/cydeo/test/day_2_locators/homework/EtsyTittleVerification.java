package com.cydeo.test.day_2_locators.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTittleVerification {
    public static void main(String[] args) {

        /*
        TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        System.out.println(driver.getTitle());

        String expectedTittle = "Wooden spoon | Etsy";
        String actualTittle = driver.getTitle();



        if (expectedTittle == actualTittle){
            System.out.println("Tittle Verification passed");
        }else {
            System.out.println("tittle verification failed");
        }

        driver.quit();

    }
}
