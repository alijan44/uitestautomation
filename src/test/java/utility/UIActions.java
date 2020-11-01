package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions {

    // Global variable
    private static WebDriver driver;
    private static WebDriverWait waits;


    public UIActions() {
        driver = Browser.getDriver();
        waits = new WebDriverWait(driver, 5);
    }

    //region BROWSER RELATED METHODS
    public void gotoSite(String url) {
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void setResolutions(int width, int height) {
        Dimension size = new Dimension(width, height);
        driver.manage().window().setSize(size);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void goFoward() {
        driver.navigate().forward();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public String title() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
    //endregion


    //region ELEMENT RELATED METHODS
    public void click(By locator) {
        try {
            WebElement element = waits.until(ExpectedConditions.elementToBeClickable(locator));
            highlight(element);
            element.click();
        } catch (Exception e) {
            System.out.println("====CLICK ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Element :  " + locator.toString() );
            System.out.println("=======================================");
        }
    }

    public void doubleClick(By locator) {

    }

    public void rightClick(By locator) {

    }

    public void dragAndDrop(By form, By target) {

    }

    public void selectOptionsWithText(By locator, String text) {

    }

    public void selectOptionsWithValue(By locator, String value) {

    }

    public void hover(By locator) {

    }

    public WebElement grabAsWebElement(By locator) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public void highlight(By locator) {
        WebElement element = grabAsWebElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "arguments[0].setAttribute('style','border: 4px solid purple;');";
        js.executeScript(script, element);
    }

    public void highlight(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "arguments[0].setAttribute('style','border: 4px solid purple;');";
        js.executeScript(script, element);
    }

    public void write(By locator, String text) {
        try {
            WebElement input = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
            highlight(input);
            input.sendKeys(text);
        }catch (Exception e) {
            System.out.println("====CLICK ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Element :  " + locator.toString() );
            System.out.println("=======================================");
        }
    }

    public void clearThenWrite(By locator, String text) {
        try {
            WebElement input = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
            input.clear();
            input.sendKeys(text);
        }catch (Exception e) {
            System.out.println("====CLICK ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Element :  " + locator.toString() );
            System.out.println("=======================================");
        }
    }

    public void clear(By locator) {
        try {
            WebElement input = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
            input.clear();
        }catch (Exception e) {
            System.out.println("====CLICK ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Element :  " + locator.toString() );
            System.out.println("=======================================");
        }
    }

    public String getText(By locator) {
        WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public boolean elementIsVisible(By locator) {
        try{
            WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();  // true, false
        }catch (Exception e) {
            System.out.println("====Element Visibility ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Determining the element visibility has failed.");
            System.out.println("=======================================");
        }
        return false;
    }

    public boolean elementIsPresent(By locator) {
        try {
            WebElement element = waits.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }catch (TimeoutException te) {
            return false;
        }
    }

    public boolean elementIsEnabled(By locator) {
        try {
            WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isEnabled();
        }catch (Exception e) {
            System.out.println("====Element Enablement ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Determining the element's enablement has failed.");
            System.out.println("=======================================");
        }
        return false;
    }

    public boolean elementIsSelected(By locator) {
        try {
            WebElement element = waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isSelected();
        }catch (Exception e){
            System.out.println("====Element SELECTED ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Determining the element's enablement has failed.");
            System.out.println("=======================================");
        }
        return false;
    }
    //endregion


    //region TIME & WAITS RELATED METHODS
    public void waitFor(int second) {
        try {
            Thread.sleep(second * 1000);
        }
        catch (InterruptedException ie) {
            System.out.println("====WAIT ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Browser has failed to wait for specified time");
            System.out.println("=======================================");
        }
    }

    public void waitForMilli(int millisecond) {
        try {
            Thread.sleep(millisecond);
        }
        catch (InterruptedException ie) {
            System.out.println("====WAIT ERROR========================");
            System.out.println("Where   :  " + driver.getCurrentUrl() );
            System.out.println("Browser has failed to wait for specified time");
            System.out.println("=======================================");
        }
    }

    public void waitUntilElementIsInvisible(By locator) {
        waits.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //endregion

}