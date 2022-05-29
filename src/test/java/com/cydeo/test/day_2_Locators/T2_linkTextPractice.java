package com.cydeo.test.day_2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_linkTextPractice {
    public static void main(String[] args) {

        /*
        1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Click to A/B Testing from top of the list.
4- Verify title is:
  Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
  Expected: Practice

         */


//        Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

//        Click to A/B Testing from top of the list
        WebElement abLinkText = driver.findElement(By.linkText("A/B Testing"));
        abLinkText.click();

//        Verify title is: Expected: No A/B Test
        String expectedTittle = "No A/B Test";
        String actualTittle = driver.getTitle();

        if (expectedTittle.equals(actualTittle)) {
            System.out.println("No A/B Tittle test Verification Passed");
        } else {
            System.out.println("No A/B Tittle test Verification failed");
        }

//        Go back to home page by using the .back();
        driver.navigate().back();

//      Verify title equals: Expected: Practice
        expectedTittle = "Practice";
        actualTittle = driver.getTitle();

        if (expectedTittle.equals(actualTittle)) {
            System.out.println("Practice Tittle Verification Passed");
        } else {
            System.out.println("Practice Tittle Verification failed");
        }

        driver.quit();
    }
}
