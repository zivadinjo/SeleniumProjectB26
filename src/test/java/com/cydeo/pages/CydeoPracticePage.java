package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoPracticePage {

    @FindBy(id = "draggable")
    public WebElement smallCircle;

    @FindBy(id = "droptarget")
    public WebElement bigCircle;

    public CydeoPracticePage() {
        PageFactory.initElements(Driver.getDriver(), this); //  PageFactory is a selenium class that support Page Object Model, and it has method called initElements once it's called , it will locate all the element specified using @FindBy annotation with locator initElements accept 2 arguments , WebDriver instance and Page class instance (this) means current instance of this class.
    }
}

