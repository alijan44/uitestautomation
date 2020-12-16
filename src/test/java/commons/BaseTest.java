package commons;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.DriverUtil;

public abstract class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverUtil.open();
    }

    @AfterMethod
    public void cleanUp() {
        DriverUtil.quit();
    }

}