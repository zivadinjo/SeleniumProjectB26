package com.cydeo.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

//    Creating a private constructor,we are closing access to it
//    object of this class outside the class
    private Driver(){

    }

//    We make WebDriver private,because we want to close access from outside class
//    We make it static,because we will use it in static method
    private static WebDriver driver; // values is null by default

    public static WebDriver getDriver(){

//         it will check if driver is null and if it is we will set up browser inside if statiement
//         if you already setup driver and using it again for following line of codes, it will return to same driver

        if(driver == null){
//            We read browserType from configuration.properties with help of ConfigurationReader class and getProperty() method
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();//this line will terminate the existing session.value will not even be null
            driver=null;
        }
    }

}
