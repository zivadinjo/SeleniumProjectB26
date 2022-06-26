package com.cydeo.test.day_18_review;

import com.cydeo.pages.JSExecutorScrollPage;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutorScrollTest {

    @Test
    public void js_executor_scroll_test() {

//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

//3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,750)");//window.scrollBy(x axis-horizontal one, y axis - vertical one0

//a.  750 pixels down 10 times.


//b.  750 pixels up 10 times

    }
}
