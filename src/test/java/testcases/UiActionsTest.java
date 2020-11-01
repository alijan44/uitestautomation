package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriver driver = Browser.getDriver();

        driver.get("https://www.google.com");
        i.waitFor(2);

        By search_box = By.name("q");
        i.write(search_box, "Stock price");

        i.waitFor(10);

    }


    @Test
    public void waitTillInvisibleTest() {
        UIActions i = new UIActions();

        i.gotoSite("http://webdriveruniversity.com/Ajax-Loader/index.html");
        i.waitUntilElementIsInvisible(By.cssSelector("div#loader"));
        Browser.getDriver().findElement(By.cssSelector("span#button1 > p")).click();
        i.waitFor(10);
    }


}
