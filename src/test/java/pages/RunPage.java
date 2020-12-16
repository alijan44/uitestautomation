package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UIActions;

import java.util.List;

public class RunPage extends UIActions {
    // List of elements we interacts in this page
    private final By page_banner = xpath("//h5[text()='Image Prediction']");
    private final By usecase_dropdown = css("select#useCases");
    private final By run_prediction_button = css("button#btnPredictionModelDesktop");
    private final By prediction_failed_text = css("div#btnImagePredictionDisplay > span");
    private final By all_imgs = xpath("//div[id='imageList']/div/img");

    // List of methods that represents user actions on this page
    public boolean pageIsDisplayed() {
        return elementIsVisible(page_banner);
    }

    public void selectUseCase(String useCaseName){
        selectOptionsWithText(usecase_dropdown, useCaseName);
    }

    public void clickRunPrediction() {
        click(run_prediction_button);
    }

    public boolean failedTextDisplayed() {
        return elementIsVisible(prediction_failed_text);
    }
}