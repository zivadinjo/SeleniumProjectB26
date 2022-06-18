package com.cydeo.test.day_14_driverUtil_javaFaker;

public class Singleton {

    private Singleton(){}

    private static String word;

    public static String getWord() {
        if(word == null){
            System.out.println("First time calling word object is null");
            word = "something";
        }else{
            System.out.println("Word is assigned and has a value");
        }
        return word;
    }
}
