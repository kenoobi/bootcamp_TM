package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
    private WebDriver driver;

    @BeforeAll
    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }

    @Test
    public void instructions(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
