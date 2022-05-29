package com.cydeo.test.day_1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com");

        // navigate().to() method is for navigating to web Page
        // driver.navigate().to("https://www.etsy.com");


        // It is using for stopping code execution in application. we are giving time to application to see steps
        Thread.sleep(3000);

        // navigate().back() method is for navigating to back from web page
        driver.navigate().back();

//        Thread.sleep(3000);

        // navigate().forward() method is for navigating to forward from web page
        driver.navigate().forward();

//        Thread.sleep(3000);

        // navigate().refresh(); method is refreshing page
        driver.navigate().refresh();

        String currentTittle = driver.getTitle();//Etsy page
        System.out.println(currentTittle);
        System.out.println("Etsy page driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.get("https://www.tesla.com");
        System.out.println("Tesla page driver.getTitle() = " + driver.getTitle());
        System.out.println("Tesla page driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //this will close currently open page
        driver.close();

        //this will close all pages,it's quiting all sessions
        driver.quit();


    }
}
