package com.cydeo.test.day_6_TestNG_StaleElement;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
    }

    @Test (priority = 2)
    public void test1(){
        System.out.println("Test1 is running ....");
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual,expected, "Test did not pass!");
    }

    @Test (priority = 1)
    public void test2(){
        System.out.println("Test2 is running...");
        Assert.assertEquals("orange","orange" ,"Test did not pass!");
    }

}
