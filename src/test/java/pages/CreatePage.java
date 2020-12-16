package pages;

import org.openqa.selenium.By;
import utility.UIActions;

public class CreatePage extends UIActions {
    // Elements user interacts with
    private final By usecase_dropdown = xpath("/html//select[@id='useCases']");
    private final By trainingdata_dropdown = xpath("/html//select[@id='datapercentage']");
    private final By augmentation_dropdown = xpath("/html//select[@id='augmentation']");
    private final By start_preprocessing_button = xpath("/html//button[@id='btnStartProcessing']");
    private final By preprocessing_wait = xpath("//div[@id='toggle']/div[@class='image_container']//div[@class='mb-25']//span[.='Preprocessing data….']");
    private final By architecture_dropdown = xpath("/html//select[@id='architecture']");
    private final By samplingmethod_dropdown = css("select#equalsampling");
    private final By lossfunction_dropdown = xpath("/html//select[@id='lossfunction']");
    private final By pretraining_dropdown = xpath("/html//select[@id='pretraining']");
    private final By earlystopping_dropdown = xpath("/html//select[@id='earlystopping']");
    private final By trainandtest_button = xpath("/html//button[@id='btnTrainAndTest']");
    private final By accuracyoverview = xpath("//div[@id='app']/div/section/section/div/div[@class='flexList']/div[1]/div[1]/div[.='Accuracy Overview']");

    // Methods that represents user actions
    public void selectUseCase(String useCaseName){
        selectOptionsWithText(usecase_dropdown, useCaseName);
        waitFor(1);
    }
    public void selectTrainingData(String trainingDataName){
        selectOptionsWithText(trainingdata_dropdown, trainingDataName);
        waitFor(1);
    }
    public void selectAugmentation(String augmentationDataName) {
        selectOptionsWithText(augmentation_dropdown, augmentationDataName);
        waitFor(2);
    }
    public void clickStartPreprocessing(){
        click(start_preprocessing_button);
        waitUntilElementIsInvisible(preprocessing_wait);
        waitFor(1);
    }
    public void selectArchitecture(String architectureName){
        selectOptionsWithText(architecture_dropdown, architectureName);
        waitFor(2);
    }
    public void selectSamplingMethod(String samplingMethodName){
        selectOptionsWithText(samplingmethod_dropdown, samplingMethodName);
        waitFor(1);
    }
    public void selectLossFunction(String lossFunctionName){
        selectOptionsWithText(lossfunction_dropdown, lossFunctionName);
        waitFor(1);
    }
    public void selectPreTraining(String preTrainingName){
        selectOptionsWithText(pretraining_dropdown, preTrainingName);
        waitFor(1);
    }
    public void selectEarlyStopping(String earlyStoppingName){
        selectOptionsWithText(earlystopping_dropdown, earlyStoppingName);
        waitFor(1);
    }
    public void clickTrainAndTest(){
        click(trainandtest_button);
        waitFor(12);

    }
    public boolean accuracyOverviewIsDisplayed(){
    return elementIsVisible(accuracyoverview);
    }

}
