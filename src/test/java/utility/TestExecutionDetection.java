package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionDetection implements ITestListener {

    // Global Variable
    private ExtentReports extent;         // Report Manager
    private ExtentSparkReporter spark;    // Report Writer
    private ExtentTest testCaseSection;   // Each testcase section in report

    // ============ TEST (Smoke) ================//
    @Override
    public void onStart(ITestContext iTestContext) {
        // Prep the report file
        // Prep the object that responsible for report creation
        extent = new ExtentReports();
        String reportFilePath = System.getProperty("user.dir") +"/reports/result.html";
        spark = new ExtentSparkReporter(reportFilePath);
        spark.config().setTheme(Theme.STANDARD);
        extent.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // Close & Save the report
        extent.flush();
    }


    // ============ TEST CASES ==================//
    @Override
    public void onTestStart(ITestResult iTestResult) {
        // Create test section in the report
        String name = iTestResult.getName();
        testCaseSection = extent.createTest(name);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // Write into that test section in the report, it was success
        testCaseSection.pass("This test case has passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // Write into that test section, it was failure
        testCaseSection.fail("This test case has failed");
        WebDriver driver = DriverUtil.getDriver();
        String picture = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        //testCaseSection.addScreenCaptureFromBase64String(picture);
        testCaseSection.addScreenCaptureFromBase64String(picture, "Failed Capture");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        testCaseSection.skip("This test case was skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
