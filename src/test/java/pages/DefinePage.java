package pages;

import org.openqa.selenium.By;
import utility.UIActions;

public class DefinePage extends UIActions {
    // Elements that user interacts with
    private final By search_bar = xpath("/html//input[@id='searchInput']");
    private final By search1 = xpath("//table[@id='defineusecase']/tbody/tr[1]/td[.='Abdominal']");
    private final By search2 = xpath("//table[@id='defineusecase']/tbody/tr[14]/td[.='AMRI HCC screening']");
    private final By search3 = xpath("//table[@id='defineusecase']/tbody/tr[30]/td[.='Abdominal, Interventional Radiology']");
    // Actions that user carries out
    public void searchHCC(){
        moveElementToDisplay(search_bar);
        write(search_bar,"HCC");
        waitFor(5);

    }
    public boolean search1Displayed() {
        return elementIsVisible(search1);
    }
    public boolean search2Displayed() {
        return elementIsVisible(search2);
    }
    public boolean search3Displayed() {
        return elementIsVisible(search3);
    }
}
