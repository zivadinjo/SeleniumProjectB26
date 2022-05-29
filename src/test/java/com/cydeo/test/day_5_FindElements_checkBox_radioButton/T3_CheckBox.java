package com.cydeo.test.day_5_FindElements_checkBox_radioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T3_CheckBox {
    public static void main(String[] args) {

//        1. Go to http://practice.cydeo.com/checkboxes
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/checkboxes");

//        2. Confirm checkbox #1 is NOT selected by default
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='box1']"));
//        if (!checkBox1.isSelected()){
//            System.out.println("checkBox1 verification is " + checkBox1.isSelected());
//        }else {
//            System.out.println("checkBox1 verification is " + checkBox1.isSelected());
//        }
        System.out.println("checkBox1 is selected = " + checkBox1.isSelected());

        
//        3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='box2']"));
//        if (checkBox2.isSelected()){
//            System.out.println("checkBox2 verification is "+ !checkBox2.isSelected());
//        }else {
//            System.out.println("checkBox2 verification is " + !checkBox2.isSelected());
//        }
        System.out.println("checkBox2 is selected = " + checkBox2.isSelected());

//        4. Click checkbox #1 to select it.
        checkBox1.click();

//        5. Click checkbox #2 to deselect it.
        checkBox2.click();

//        6. Confirm checkbox #1 is SELECTED.
        WebElement checkBox11 = driver.findElement(By.xpath("//input[@id='box1']"));
        System.out.println("checkBox11 is selected = " + checkBox11.isSelected());


//        7. Confirm checkbox #2 is NOT selected
        WebElement checkBox22 = driver.findElement(By.xpath("//input[@id='box2']"));
        System.out.println("checkBox22 is selected = " + checkBox22.isSelected());

        driver.quit();

    }
}
