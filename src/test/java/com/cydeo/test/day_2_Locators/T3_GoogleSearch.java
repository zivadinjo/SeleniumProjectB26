package com.cydeo.test.day_2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {

        /*
        1- Open a chrome browser
        2- Go to: https://google.com/
        3- Write “apple” in search box
        4- Click google search button
        5- Verify title:
        Expected: Title should start with “apple” word
         */

//        Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Go to: https://google.com/
        driver.get("https://google.com/");

//        Write “apple” in search box and Click google search button
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);

//        Verify title : Expected: Title should start with “apple” word
        String actualTittle = "apple";
        String expectedTittle = driver.getTitle();

        System.out.println(expectedTittle);

        if(expectedTittle.startsWith(actualTittle)){
            System.out.println("Tittle verification Passed");
        }else{
            System.out.println("Tittle verification Failed");
        }
        driver.quit();


    }
}
