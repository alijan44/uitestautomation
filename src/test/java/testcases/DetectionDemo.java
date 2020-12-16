package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.DriverUtil;

public class DetectionDemo {

    @Test
    public void testcase1() {
        System.out.println("Test case 1");
    }

    @Test
    public void testcase2() {
        System.out.println("Test case 2");
    }

    @Test
    public void testcase3() {
        System.out.println("Test case 3");
        Assert.assertTrue(false);
    }


    @Test
    public void testcase4() {
        System.out.println("Test case 4");
    }

    @Test
    public void testcase5() {
        System.out.println("Test case 5");
    }
}