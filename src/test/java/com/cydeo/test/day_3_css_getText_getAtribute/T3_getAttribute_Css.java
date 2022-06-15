package com.cydeo.test.day_3_css_getText_getAtribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_getAttribute_Css {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
         */
//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//        3- Verify “Log in” button text is as expected:
//        Expected: Log In
        WebElement loginBtn = driver.findElement(By.cssSelector("input[class='login-btn']"));

        String expected = "Log In";
        String actual = loginBtn.getAttribute("value");

        if (expected.equals(actual)){
            System.out.println("Log in button text verification passed");
        }else {
            System.out.println("Log in button text verification failed");
        }

        driver.quit();

    }
}
