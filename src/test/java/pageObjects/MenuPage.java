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

    @FindBy(how = How.CSS, using = ".oxd-userdropdown-tab")
    private WebElement btn_profile;

    @FindBy(how = How.CSS, using = "[href='/web/index.php/auth/logout']")
    private WebElement btn_logOut;

    @FindBy(how = How.CSS, using = ".oxd-userdropdown-link[href='#']")
    private WebElement btn_about;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/time/viewTimeModule']")
    private WebElement btn_time_option;

    @FindBy(how = How.CSS, using = ".orangehrm-left-space")
    private WebElement btn_view_time_option;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/dashboard/index']")
    private WebElement btn_dashboard_option;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/directory/viewDirectory']")
    private WebElement btn_directory_option;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/buzz/viewBuzz']")
    private WebElement btn_buzz_option;

    @FindBy(how = How.CSS, using = ".oxd-userdropdown-link[href='/web/index.php/help/support']")
    private WebElement btn_profile_support;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-button")
    private WebElement btn_menu_hide;

    @FindBy(how = How.CSS, using = ".oxd-userdropdown-link[href='/web/index.php/pim/updatePassword']")
    private WebElement btn_profile_password;

    @FindBy(how = How.CSS, using = ".oxd-input[placeholder='Search']")
    private WebElement txt_search_field;

    @FindBy(how = How.CSS, using = ".oxd-userdropdown-link[href='/web/index.php/auth/logout']")
    private WebElement btn_profile_logout;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/pim/viewMyDetails']")
    private WebElement btn_menu_myinfo;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/maintenance/viewMaintenanceModule']")
    private WebElement btn_menu_maintenance;

    @FindBy(how = How.CSS, using = ".oxd-input[name='password']")
    private WebElement txt_maintenance_password_field;

    @FindBy(how = How.CSS, using = " .orangehrm-admin-access-button[type='submit']")
    private WebElement btn_maintenance_confirm_password;

    @FindBy(how = How.CSS, using = ".oxd-main-menu-item[href='/web/index.php/recruitment/viewRecruitmentModule']")
    private WebElement btn_menu_recruitment;


    @FindBy(how = How.CSS, using = ".--visited.oxd-topbar-body-nav-tab")
    private WebElement btn_tag_vacancies;


    public void each_menu_option(){
        for (int i = 0; i < txt_menu.size(); i++){
            txt_menu.get(i).click();
        }
    }

    public int menu_size(){
        return txt_menu.size();
    }

    public void click_on_profile(){
        btn_profile.click();
    }

    public void click_on_logOut(){
        btn_logOut.click();
    }

    public void click_on_about(){
        btn_about.click();
    }
    public void click_on_time(){
        btn_time_option.click();
    }

    public void click_on_view_time_option(){
        btn_view_time_option.click();
    }

    public void click_on_dashboard_option(){
        btn_dashboard_option.click();
    }

    public void click_on_directory_option(){
        btn_directory_option.click();
    }

    public void click_on_buzz_option(){
        btn_buzz_option.click();
    }

    public void click_on_profile_support(){
        btn_profile_support.click();
    }

    public void click_on_menu_hide(){
        btn_menu_hide.click();
    }

    public void click_on_profile_password(){
        btn_profile_password.click();
    }

    public void type_in_search_field(String text){
        txt_search_field.sendKeys(text);
    }

    public void type_in_maintenance_password(String text){
        txt_maintenance_password_field.sendKeys(text);
    }

    public void click_on_profile_logout(){
        txt_search_field.click();
    }
    public void click_on_menu_my_info(){
        btn_menu_myinfo.click();
    }

    public void click_on_menu_maintenance(){
        btn_menu_maintenance.click();
    }

    public void click_on_maintenance_confirm(){
        btn_maintenance_confirm_password.click();
    }

    public void click_on_menu_recruitment(){
        btn_menu_recruitment.click();
    }

    public void click_on_recruitment_vacancies_tag(){
        btn_tag_vacancies.click();
    }


}
