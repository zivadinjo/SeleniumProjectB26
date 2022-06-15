package com.cydeo.test.day_3_css_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Locators_getText {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("incorrect");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        WebElement errorMsg= driver.findElement(By.className("errortext"));

        String actualText = errorMsg.getText(); // getText(); method will get text fromWebElement
        String expectedText = "Incorrect login or password";

        if (expectedText.equals(actualText)){
            System.out.println("Incorrect login and password verification passed");
        } else {
            System.out.println("Incorrect login and password verification failed");
        }

        driver.quit();

    }
}
