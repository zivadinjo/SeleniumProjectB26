package com.cydeo.test.day_5_FindElements_checkBox_radioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_RadioButton2 {
    public static void main(String[] args) {

        //        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");


//      Locating ALL favorite sport radio buttons
        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement each : radioButton) {
            each.click();
            System.out.println("Radio button "+ each.isSelected());
        }
        driver.quit();

    }
}
