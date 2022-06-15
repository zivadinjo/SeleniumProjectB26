package com.cydeo.test.day_12_learningProperties;

import org.testng.annotations.Test;

public class learningProperties {

    @Test
    public void java_properties_reading_test(){
//      key     =   value
//      os.mame =   Windows 10
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }

}
