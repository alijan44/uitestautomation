package pages;

import org.openqa.selenium.By;
import utility.UIActions;

public class EvaluatePage extends UIActions {
    // List of element user interacts in this page
    private final By usecase_dropdown = id("useCases");
    private final By dataset_dropdown = id("useCaseSelect");
    private final By company1_checkbox = xpath("//tr[@data-site='Site A'][1]");
    private final By company2_checkbox = xpath("//tr[@data-site='Site A'][2]");
    private final By evaluate_models_button = css(".btn.btn-primary.btn-round.ml-20");
    private final By first_result_text = xpath("//div[@class='flexList']/div[1]/div[2]/div[2]/div[1]");
    private final By second_result_text = xpath("//div[@class='flexList']/div[2]/div[2]/div[2]/div[1]");

    // List of methods that represents users actions in this page
    public void selectUseCase(String useCaseName) {
        selectOptionsWithText(usecase_dropdown, useCaseName);
        waitFor(2);
    }

    public void selectDataset(String datasetName) {
        selectOptionsWithText(dataset_dropdown, datasetName);
        waitFor(2);
    }

    public void selectModels() {
        click(company1_checkbox);
        click(company2_checkbox);
        waitFor(2);
    }

    public void clickEvaluateButton() {
        click(evaluate_models_button);
        waitFor(5);
    }

    public boolean verifyFirstResultText() {
        waitFor(1);
        return elementIsVisible(first_result_text);
    }

    public boolean verifySecondResultText() {
        waitFor(1);
        return elementIsVisible(second_result_text);
    }

}