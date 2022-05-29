package com.cydeo.test.day_2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacebookTitleVerification {

    public static void main(String[] args) {

        /*
        1. Open Chrome browser
        2. Go to https://www.facebook.com/
        3. Verify title:
        Expected: “Facebook - log in or sign up”
         */

//        Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Go to https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");

//        Verify title
//        Expected: “Facebook - log in or sign up”
        String expectedTittle = "Facebook - log in or sign up";
        String actualTittle = driver.getTitle();

        if(actualTittle.equals(expectedTittle)){
            System.out.println("Verification Passed ");
        }else{
            System.out.println("Verification Failed");
        }
        driver.quit();




    }
}
