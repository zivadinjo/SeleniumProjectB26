package com.cydeo.test.day_16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.testng.annotations.Test;

public class T2_Actions_Scroll {
    @Test
    public void actions_scroll_test(){
//    1- Open a chrome browser
//    2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("practice.page.url"));

//    3- Scroll down to “Powered by CYDEO”

//    4- Scroll using Actions class “moveTo(element)” method

//    1- Continue from where the Task 4 is left in the same test.
//    2- Scroll back up to “Home” link using PageUP button

    }
}
