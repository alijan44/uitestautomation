package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.DriverUtil;
import utility.UIActions;

public class UiActionsTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("set up");
    }


    @AfterMethod
    public void cleanUp() {
        System.out.println("clean up ");
    }


    @Test
    public void goinToWebsiteTest() {
        System.out.println("test");

    }


    @Test
    public void waitTillInvisibleTest() {
        System.out.println("test");
    }


    @Test
    public void doublClickTest() {
        System.out.println("test");
    }


    @Test
    public void moveToViewTest() {
        System.out.println("test");
    }

    @Test
    public void demo() {
        System.out.println("test");

    }

    @Test
    public void testSelectAbstractedMethods() {
        System.out.println("test");
    }

    @Test
    public void clickWithtext() {
        System.out.println("test");
    }

}

