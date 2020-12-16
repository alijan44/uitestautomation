package pages;

import org.openqa.selenium.By;
import utility.UIActions;

public class AnnotatePage extends UIActions {
    // Elements that user will interact
    private final By annoate_page_banner = css(".counter > div");
    private final By almost_entirely_fat = xpath("//section[@id='conerStoneViewer']/section[@class='questions']/ul/li[1]/div");
    private final By next_button = xpath("/html//button[@id='nextStudyBtn']");
    private final By scattered_fibro_densities = css("li:nth-of-type(2) > div");
    private final By extremely_dense = xpath("//section[@id='conerStoneViewer']/section[@class='questions']/ul/li[4]/div");
    private final By finish_button = xpath("//section[@id='conerStoneViewer']/section[@class='questions']//button[@title='Finish the contest']");
    private final By congrats_message = css(".pb-20 > span");
    private final By main_dropdown = xpath("/html//select[@id='useCases']");
    private final By pneumopresent = xpath("//section[@id='conerStoneViewer']/section[@class='questions']/ul/li[1]/div");
    private final By numberofannotations = xpath("//section[@id='conerStoneViewer']/section[@class='questions']/div[@class='counter']/div");



    // Actions that user carries out
    public boolean pageIsDisplayed() {
        return elementIsVisible(annoate_page_banner);
    }

    public void clickAlmostEntirelyFat() {
        click(almost_entirely_fat);
        waitFor(1);
    }
    public void clickNextButton() {
        click(next_button);
        waitFor(1);
    }
    public void clickScattered() {
        click(scattered_fibro_densities);
        waitFor(1);
    }
    public void clickExtremelyDense(){
        click(extremely_dense);
        waitFor(1);
    }
    public void clickFinishButton(){
        click(finish_button);
        waitFor(1);
    }
    public boolean congratsIsDisplayed(){
        return elementIsVisible(congrats_message);
    }
    public void selectMainDropdown(String dropDownName){
        selectOptionsWithText(main_dropdown, dropDownName);
        waitFor(1);
    }
    public void clickPneumoPresent(){
        click(pneumopresent);
        waitFor(1);
    }
    public boolean numberOfAnnotationsIsCorrect(){
        return elementIsVisible(numberofannotations);
    }
}