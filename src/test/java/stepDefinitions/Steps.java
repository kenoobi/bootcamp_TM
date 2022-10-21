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
        Assert.assertEquals(true, driver.findElement(By.cssSelector(".oxd-topbar-header")).isDisplayed());
    }

    @When("click on each menu option")
    public void click_on_article(){
        MenuPage menu = new MenuPage(driver);
        menu.each_menu_option();
    }

    @Then("validate option")
    public void validate_menu_option(String menu_option){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(true, driver.findElement(By.cssSelector(".oxd-topbar-header-breadcrumb")).isDisplayed());
    }

    @When("^search Employee id (\\d+)$")
    public void search_employee_id(int employee_id) throws Throwable {
        PIM pim = new PIM(driver);
        pim.search_employee_id(employee_id);
        pim.click_on_search();
    }

    @Then("^validate employee id (\\d+)$")
    public void validate_employee_id(int employee_id) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Assert.assertEquals(true, driver.findElement(By.cssSelector("[role='row'] [role='cell']:nth-child(2)")).isDisplayed());
        Assert.assertEquals(employee_id,driver.findElement(By.cssSelector("[role='row'] [role='cell']:nth-child(2)")).getAttribute("text") );
    }


}
