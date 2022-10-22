package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "username")
    private WebElement txtbx_Username;

    @FindBy(how = How.NAME, using = "password")
    private WebElement txtbx_Pwd;

    @FindBy(how = How.CSS, using = ".orangehrm-login-button")
    private WebElement btn_Login;

    @FindBy(how = How.CSS, using = ".orangehrm-login-forgot-header")
    private WebElement btn_forgot_pwd;


    public void enter_username(String name) {
        txtbx_Username.sendKeys(name);
    }

    public void enter_pwd(String lastName) {
        txtbx_Pwd.sendKeys(lastName);
    }

    public void clickOn_BtnLogin() {
        btn_Login.submit();

    }

    public void fill_FastAccess() {
        enter_username("Admin");
        enter_pwd("admin123");
    }

    public void click_on_forogt_pwd(){
        btn_forgot_pwd.click();
    }

}
