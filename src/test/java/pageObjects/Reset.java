package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Reset {

    public Reset(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".oxd-input")
    private WebElement txta_username;

    @FindBy(how = How.CSS, using = ".orangehrm-forgot-password-button--reset")
    private WebElement btn_reset_pwd;

    public void fill_username(String username){
        txta_username.sendKeys(username);
    }

    public void click_on_reset_pwd(){
        btn_reset_pwd.click();
    }
}
