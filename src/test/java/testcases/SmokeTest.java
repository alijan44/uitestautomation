package testcases;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AnnotatePage;
import pages.EvaluatePage;
import pages.RunPage;
import pages.WelcomePage;


public class SmokeTest extends BaseTest {

    @Test
    public void verifyUserCanGoToWelcomePage() {
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        boolean result = welcome.pageIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyUserCanGoToAnnotatePageFromHomePage() {
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        welcome.clickAnnotateButton();
        AnnotatePage annotate = new AnnotatePage();
        boolean result = annotate.pageIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyRunPageIsReachableFromHome() {
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        welcome.clickRunButton();
        RunPage run = new RunPage();
        boolean result = run.pageIsDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyBDRunInferenceFails() {
        // Page objects
        WelcomePage welcomePage = new WelcomePage();
        RunPage runPage = new RunPage();

        // Test Scripts
        welcomePage.openAilab();
        welcomePage.clickRunButton();
        runPage.selectUseCase("Breast Density");
        runPage.clickRunPrediction();
        boolean result = runPage.failedTextDisplayed();
        result = false;
        Assert.assertTrue(result);
    }


    @Test
    public void verifyPneumoniaRunInferenceFails() {

        // Page objects
        WelcomePage welcomePage = new WelcomePage();
        RunPage runPage = new RunPage();

        // Test Scripts
        welcomePage.openAilab();
        welcomePage.clickRunButton();
        runPage.selectUseCase("Pneumonia");
        runPage.clickRunPrediction();
        boolean result = runPage.failedTextDisplayed();

        Assert.assertTrue(result);
    }

    @Test
    public void verifyEvalationPage() {
        WelcomePage welcomePage = new WelcomePage();
        EvaluatePage evaluatePage = new EvaluatePage();

        welcomePage.openAilab();
        welcomePage.clickEvaluateButton();

        evaluatePage.selectUseCase("Breast Density");
        evaluatePage.selectDataset("Site A - Breast Density Dataset");
        evaluatePage.selectModels();
        evaluatePage.clickEvaluateButton();
        boolean result1 = evaluatePage.verifyFirstResultText();
        boolean result2 = evaluatePage.verifySecondResultText();

        SoftAssert asserts = new SoftAssert();
        asserts.assertTrue(result1);
        asserts.assertTrue(result2);
        asserts.assertAll();
    }
}