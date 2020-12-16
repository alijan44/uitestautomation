package pages;

import org.openqa.selenium.By;
import utility.UIActions;

public class WelcomePage extends UIActions {

    // Elements that user will interact
    private final By enter_button = xpath("//a/button");
    private final By welcome_page_banner = css(".col-md-12.mt-10 h1");
    private final By learn_button = css("button#btnLearn");
    private final By define_button = css("button#btnDefineUse");
    private final By annotate_button = css("button#btnAnnotate");
    private final By create_button = xpath("//form[@id='loginForm']/div[@class='site-menubar']//ul//a[@href='Create/TrainAndTest']/span[@class='site-menu-title']");
    private final By run_button = css("button#btnRun");
    private final By evaluate_button = css("button#btnRunAndEvaluate");


    // Actions that user carries out
    public void openAilab() {
        gotoSite("https://ailab.acr.org/");
        click(enter_button);
    }
    public void clickCreateButton(){
        click(create_button);
        waitFor(5);
    }
    public boolean pageIsDisplayed() {
        return elementIsVisible(welcome_page_banner);
    }

    public void clickAnnotateButton() {
        click(annotate_button);
        waitFor(5);
    }

    public void clickRunButton() {
        moveElementToDisplay(run_button);
        click(run_button);

    }

    public void clickEvaluateButton(){
        moveElementToDisplay(evaluate_button);
        waitFor(5);
        click(evaluate_button);
    }

    public void clickDefineButton(){
        moveElementToDisplay(define_button);
        click(define_button);
        waitFor(15);
    }

}

