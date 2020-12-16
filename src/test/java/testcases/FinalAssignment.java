package testcases;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnnotatePage;
import pages.CreatePage;
import pages.DefinePage;
import pages.WelcomePage;


public class FinalAssignment extends BaseTest {

    @Test
    public void test1() {
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        welcome.clickDefineButton();

        DefinePage define = new DefinePage();
        define.searchHCC();

        boolean result1 = define.search1Displayed();
        Assert.assertTrue(result1);
        boolean result2 = define.search2Displayed();
        Assert.assertTrue(result2);
        boolean result3 = define.search3Displayed();
        Assert.assertTrue(result3);

    }
    @Test
    public void test2(){
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        welcome.clickAnnotateButton();

        AnnotatePage annotate = new AnnotatePage();

        annotate.clickAlmostEntirelyFat();
        annotate.clickNextButton();
        annotate.clickScattered();
        annotate.clickNextButton();
        annotate.clickExtremelyDense();
        annotate.clickNextButton();
        annotate.clickFinishButton();

        boolean congratulations = annotate.congratsIsDisplayed();
        Assert.assertTrue(congratulations);

    }
    @Test
    public void test3(){
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        welcome.clickAnnotateButton();

        AnnotatePage annotate = new AnnotatePage();

        annotate.selectMainDropdown("Pneumothorax");
        annotate.clickPneumoPresent();
        annotate.clickNextButton();
        annotate.clickPneumoPresent();
        annotate.clickNextButton();
        annotate.clickPneumoPresent();
        annotate.clickNextButton();
        annotate.clickPneumoPresent();
        annotate.clickNextButton();
        annotate.clickPneumoPresent();
        annotate.clickNextButton();

        boolean annotations = annotate.numberOfAnnotationsIsCorrect();
        Assert.assertTrue(annotations);

    }
    @Test
    public void test4(){
        WelcomePage welcome = new WelcomePage();
        welcome.openAilab();
        welcome.clickCreateButton();

        CreatePage create = new CreatePage();

        create.selectUseCase("Breast Density");
        create.selectTrainingData("1000 Mammo images");
        create.selectAugmentation("Random flips/rotations");
        create.clickStartPreprocessing();
        create.selectArchitecture("ResNet");
        create.selectSamplingMethod("Random sampling");
        create.selectLossFunction("Categorical-crossentropy");
        create.selectPreTraining("Pre-trained weights");
        create.selectEarlyStopping("TRUE");
        create.clickTrainAndTest();

        boolean accuracyOverview = create.accuracyOverviewIsDisplayed();
        Assert.assertTrue(accuracyOverview);

    }
}
