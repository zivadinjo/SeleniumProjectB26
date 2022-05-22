package com.cydeo.test.day_3_Css_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_getText_getAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form ");

        WebElement header = driver.findElement(By.tagName("h2"));

        String expected = "Registration form";
        String actual = header.getText();

        if (expected.equals(actual)){
            System.out.println("Header Text verification passed");
        }else {
            System.out.println("Header Text verification failed");
        }

        WebElement firstName = driver.findElement(By.name("firstname"));
        String expectedName = "first name";
        // getAttribute method (attribute argument)
        String actualName = firstName.getAttribute("placeholder");

        if (expectedName.equals(actualName)){
            System.out.println("First name verification passed");
        }else {
            System.out.println("First name verification failed");
        }

        driver.quit();

    }
}
