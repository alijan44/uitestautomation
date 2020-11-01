package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Browser;
import utility.UIActions;

public class UiActionsTest {

    @BeforeMethod
    public void setUp() {
        Browser.open();
    }


    @AfterMethod
    public void cleanUp() {
        Browser.quit();
    }


    @Test
    public void goinToWebsiteTest() {
        UIActions i = new UIActions();

        i.gotoSite("https://www.google.com");
        By search_input = By.name("qasdfa");
        boolean isPrsent = i.elementIsPresent(search_input);
        System.out.println(isPrsent);
        i.waitFor(3);
    }


}
