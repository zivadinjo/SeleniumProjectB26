package com.cydeo.test.day_17_pom_syncronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_POM_ActionsPractice {

    CydeoPracticePage cydeoPracticePage;
    Actions actions;
    @BeforeMethod
    public void setUpMethod(){
        //    1. Open a chrome browser
//    2. Go to: https://practice.cydeo.com/drag_and_drop_circles

        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        cydeoPracticePage = new CydeoPracticePage();
        actions = new Actions(Driver.getDriver());

//        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage(); -> when you move it from test to Before method,it became local only to Before method,that's why we write it down before @Before method, so it can be reachable for every test  method,and it's initialized in @before method
    }

    @Test
    public void drag_small_circle_text() {
//    3. Verify expected default text appears on big circle
//    Expected = "Drag the small circle here."

        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drag the small circle here.");

    }

    @Test
    public void drop_text_here() {

//    TC #3: Cydeo Practice Drag and Drop Test
//    1. Open a chrome browser
//    2.  Go to:https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage();

//     3. Click and hold small circle
//        Actions actions = new Actions(Driver.getDriver());-> moved on the top so it can be accessible by all methods,and it is initialized in @Before method
        actions.moveToElement(cydeoPracticePage.smallCircle).clickAndHold().moveByOffset(100,50).perform(); // finding,clicking and holding small circle,moveByOffset moves circle by X and Y axis, and it allows to show up drop here in big circle

//     4. Verify "Drop here." text appears on big circle

        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(),"Drop here.");

        Driver.closeDriver();

    }

}
