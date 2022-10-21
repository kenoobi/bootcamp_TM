package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIM {

    public PIM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "[data-v-89f667ec=''] .oxd-input--active")
    private WebElement txtb_Employee_id;

    @FindBy(how = How.CSS, using = ".orangehrm-left-space")
    private WebElement btn_search;

    @FindBy(how = How.CSS, using = "[role='row'] [role='cell']:nth-child(2)")
    private WebElement txt_id_found;

    public void search_employee_id(int employee_name){
        txtb_Employee_id.sendKeys(""+employee_name);
    }

    public void click_on_search(){
        btn_search.click();
    }
}
