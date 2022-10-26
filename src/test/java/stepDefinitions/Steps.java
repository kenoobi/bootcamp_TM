package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Login;
import pageObjects.MenuPage;
import pageObjects.PIM;
import pageObjects.Reset;

import java.time.Duration;

public class Steps {

    private WebDriver driver;

    // Start variables
    @Given("start the web")
    public void start_the_web() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("^try log in with (.*) and (.*)$")
    public void try_login_with_username_and_password(String username, String password){
        Login login = new Login(driver);
        login.enter_username(username);
        login.enter_pwd(password);
        login.clickOn_BtnLogin();
    }

    // Behavior
    @When("try log in")
    public void try_log_in() {
        Login login = new Login(driver);
        login.fill_FastAccess();
        login.clickOn_BtnLogin();
    }

    // Asserts
    @When("login success")
    public void login_success() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //success message
        Assert.assertEquals(true, driver.findElement(By.cssSelector(".oxd-topbar-header")).isDisplayed() ||
                driver.findElement(By.cssSelector(".oxd-input-group__message")).isDisplayed() ||
                driver.findElement(By.cssSelector(".oxd-alert-content-text")).isDisplayed());
    }

    @When("login non success")
    public void login_non_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-input-field-error-message")).isDisplayed());
    }

    @When("click on each menu option")
    public void click_on_article(){
        MenuPage menu = new MenuPage(driver);
        menu.each_menu_option();
    }

    @Then("validate option")
    public void validate_menu_option(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-topbar-header-breadcrumb")).isDisplayed());
        driver.quit();
    }

    @When("^search Employee id (.*)$")
    public void search_id(String employee) {
        PIM pim = new PIM(driver);
        pim.search_employee_id(employee);
        pim.click_on_search();
    }

    @Then("validate employee id")
    public void validate_employee_id() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector("[role='row'] [role='cell']:nth-child(2)")).isDisplayed());
    }

    @When("click on forgot password")
    public void click_on_forgot_password() {
        Login login = new Login(driver);
        login.click_on_forogt_pwd();
    }

    @When("copy the username and click on the button reset pwd")
    public void copy_username_click_on_reset_pwd() {
        Reset reset = new Reset(driver);
        reset.fill_username("Admin");
        reset.click_on_reset_pwd();
    }

    @Then("validate popup")
    public void validate_popup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-card-container")).isDisplayed());
    }

    @When("click on txt url")
    public void click_on_txt_url(){
        Login login = new Login(driver);
        login.click_on_btn_orange_inc();
    }

    @Then("validate web site")
    public void validate_web_site(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.partialLinkText("orangehrm.com")).isDisplayed());
    }

    @When("click on add employee")
    public void click_on_add_employee(){
        PIM pim = new PIM(driver);
        pim.click_on_add_employee();
        pim.click_on_save_employee();
    }

    @Then("validate the required fields")
    public void validate_required_fields(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-input-group__message")).isDisplayed());
    }

    @And("click on profile and click log out")
    public void clickOnProfileAndClickLogOut() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_profile();
        menuPage.click_on_logOut();
    }

    @Then("validate the log out")
    public void validateTheLogOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-login-logo")).isDisplayed());
    }

    @And("click on about button into profile")
    public void clickOnAboutButtonIntoProfile() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_profile();
        menuPage.click_on_about();
    }

    @Then("validate the profile fields")
    public void validateTheProfileFields() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-dialog-sheet")).isDisplayed());
    }

    @And("click on time option")
    public void clickOnTimeOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_time();
        menuPage.click_on_view_time_option();
    }

    @Then("Validate found data")
    public void validateFoundData() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-v-77b08b9a='']")).isDisplayed());
    }

    @And("click on dashboard option")
    public void clickOnDashboardOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_dashboard_option();
    }

    @Then("validate image of launching soon")
    public void validateImageOfLaunchingSoon() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-module-under-development")).isDisplayed());
    }

    @And("click on directory option")
    public void clickOnDirectoryOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_directory_option();
    }

    @Then("validate the data of the directory")
    public void validateTheDataOfTheDirectory() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-container")).isDisplayed());
    }

    @And("click on buzz option")
    public void clickOnBuzzOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_buzz_option();
    }

    @And("click on support button")
    public void clickOnSupportButton() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_profile();
        menuPage.click_on_profile_support();
    }

    @Then("validate the support window")
    public void validateTheSupportWindow() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-card-container")).isDisplayed());
    }

    @Then("click on button hide menu and validate")
    public void clickOnButtonHideMenuAndValidate() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_menu_hide();
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-main-menu-item.toggle")).isDisplayed());
    }

    @And("click profile and password option")
    public void clickProfileAndPasswordOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_profile();
        menuPage.click_on_profile_password();
    }

    @Then("validate the update password screen")
    public void validateTheUpdatePasswordScreen() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-card-container")).isDisplayed());
    }

    @And("Search Admin in the search field")
    public void searchAdminInTheSearchField() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.type_in_search_field("Admin");
    }

    @Then("validate that the found menu option is correct")
    public void validateThatTheFoundMenuOptionIsCorrect() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector("[href='/web/index.php/admin/viewAdminModule']")).isDisplayed());
    }


    @And("click on profile and log out option")
    public void clickOnProfileAndLogOutOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_profile();
        menuPage.click_on_profile_logout();
    }

    @Then("validate log out success")
    public void validateLogOutSuccess() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-login-slot")).isDisplayed());

    }

    @And("click on my info menu option")
    public void clickOnMyInfoMenuOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_menu_my_info();
    }

    @Then("validate that the panel my info is available")
    public void validateThatThePanelMyInfoIsAvailable() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-background-container")).isDisplayed());
    }


    @And("click on maintenance option")
    public void clickOnMaintenanceOption() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_menu_maintenance();
    }


    @And("type the admin password")
    public void typeTheAdminPassword() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.type_in_maintenance_password("admin123");
        menuPage.click_on_maintenance_confirm();
    }

    @Then("validate the window")
    public void validateTheWindow() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-background-container")).isDisplayed());
    }

    @And("click on menu recruitment option and click on the tag vacancies")
    public void clickOnMenuRecruitmentOptionAndClickOnTheTagVacancies() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.click_on_menu_recruitment();
        menuPage.click_on_recruitment_vacancies_tag();
    }

    @Then("validate if exist available vacancies")
    public void validateIfExistAvailableVacancies() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-table-row")).isDisplayed());
    }
}
