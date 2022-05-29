package com.cydeo.test.day_4_cssSelector_xPath;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_Css_IsDisplayed {
    public static void main(String[] args) {
//
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
//        3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
//        a. “Home” link
        WebElement homelink = driver.findElement(By.cssSelector("a[class='nav-link']"));
//        b. “Forgot password” header
        WebElement forgotPass = driver.findElement(By.cssSelector("div[class='example']>h2"));
//        c. “E-mail” text
        WebElement eMail = driver.findElement(By.cssSelector("label[for = 'email']"));
//        d. E-mail input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[name='email']"));
//        e. “Retrieve password” button
        WebElement retrievePass = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
//        f. “Powered by Cydeo text
        WebElement poweredBy = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
//        4. Verify all web elements are displayed.
        System.out.println("homelink.isDisplayed() = " + homelink.isDisplayed());
        System.out.println("forgotPass.isDisplayed() = " + forgotPass.isDisplayed());
        System.out.println("eMail.isDisplayed() = " + eMail.isDisplayed());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("retrievePass.isDisplayed() = " + retrievePass.isDisplayed());
        System.out.println("poweredBy.isDisplayed() = " + poweredBy.isDisplayed());
        driver.quit();


    }
}
