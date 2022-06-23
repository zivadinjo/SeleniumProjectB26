package com.cydeo.test.day_16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T2_Actions_Scroll {
    @Test
    public void actions_scroll_test(){
//    1- Open a chrome browser
//    2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("practice.page.url"));

//    3- Scroll down to “Powered by CYDEO”
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

//    4- Scroll using Actions class “moveTo(element)” method
//There two ways to do Scrolling in Actions class
// 1.moveToElement()
// 2.Keys.PAGE_UP and Keys.PAGE_DOWN -> moves it doesn't need web element
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(cydeoLink).perform();

//    1- Continue from where the previous task is left in the same test.
//    2- Scroll back up to “Home” link using PageUP button

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));
//        actions.sendKeys(Keys.PAGE_UP).perform(); -> it needs multiple PAGE_UP Keys to scroll all the way up,need to figure it out by running the code
        actions.moveToElement(homeLink).perform();

        Driver.closeDriver();

    }
}
