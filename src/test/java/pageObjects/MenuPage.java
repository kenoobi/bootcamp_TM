package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MenuPage {

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how = How.CSS, using = ".oxd-main-menu-item-wrapper span[class^='oxd']"))
    private List<WebElement> txt_menu;

    public void each_menu_option(){
        for (int i = 0; i < txt_menu.size(); i++){
            txt_menu.get(i).click();
        }
    }

    public int menu_size(){
        return txt_menu.size();
    }

}
