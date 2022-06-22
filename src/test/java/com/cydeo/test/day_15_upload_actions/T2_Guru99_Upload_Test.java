package com.cydeo.test.day_15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {

    @Test
    public void upload_file_test() throws InterruptedException {

//    1. Go to “https://demo.guru99.com/test/upload”

        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.upload.url"));

//    2. Upload file into Choose File

        WebElement choseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "C:\\Users\\zivad\\OneDrive\\Desktop\\B26\\Softskills\\some-file.txt";
        choseFile.sendKeys(path);

//    3. Click terms of service checkbox

        WebElement termsOfService = Driver.getDriver().findElement(By.id("terms"));
        termsOfService.click();


//    4. Click Submit File button

        WebElement submitFile = Driver.getDriver().findElement(By.id("submitbutton"));
        submitFile.click();


//    5. Verify expected message appeared.
//    Expected: “1 file has been successfully uploaded.”

        WebElement resultMsg = Driver.getDriver().findElement(By.id("res"));
        String actualResult = resultMsg.getText();
        String expectedResult = "1 file\nhas been successfully uploaded.";
        Thread.sleep(3000); // was failing because of waiting time,added thread sleep to resolve issue
        Assert.assertEquals(actualResult,expectedResult,"Verification failed");

        Driver.closeDriver();

    }

}
