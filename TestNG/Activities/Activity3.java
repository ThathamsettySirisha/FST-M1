package Activities;
import io.github.bonigarcia.wdm.WebDriverManager; // For WebDriverManager setup
import org.openqa.selenium.By; // For locating web elements
import org.openqa.selenium.WebDriver; // For WebDriver interface
import org.openqa.selenium.WebElement; // For WebElement interface
import org.openqa.selenium.firefox.FirefoxDriver; // For FirefoxDriver
import org.testng.Assert; // For assertion
import org.testng.annotations.AfterClass; // For afterClass annotation
import org.testng.annotations.BeforeClass; // For beforeClass annotation
import org.testng.annotations.Test; // For Test annotation

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefox().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void loginTest() {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        //Enter credentials
        username.sendKeys("admin");
        password.sendKeys("password");

        //Click login
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Read login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}