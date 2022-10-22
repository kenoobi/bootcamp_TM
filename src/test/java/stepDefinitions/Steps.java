package stepDefinitions;

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

    // Behavior
    @When("try log in")
    public void try_log_in() {
        Login login = new Login(driver);
        login.fill_FastAccess();
        login.clickOn_BtnLogin();
    }

    // Asserts
    @When("login success")
    public void login_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-topbar-header")).isDisplayed());
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

}
