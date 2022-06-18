package com.cydeo.test.day_13_configuration_reader;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_configuration_practice extends TestBase {

    @Test
    public void login_crm_app(){
//        2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

//        3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

//        4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

//        5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

//        6. Verify title is as expected:
//        Expected: Portal
        //    BrowserUtils.verifyTitle(driver,"(1) Portal");

    }

}
