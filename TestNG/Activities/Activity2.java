package Activities;
import io.github.bonigarcia.wdm.WebDriverManager; // For WebDriverManager setup
import org.openqa.selenium.By; // For locating web elements
import org.openqa.selenium.WebDriver; // For WebDriver interface
import org.openqa.selenium.WebElement; // For WebElement interface
import org.openqa.selenium.firefox.FirefoxDriver; // For FirefoxDriver
import org.testng.Assert; // For assertion
import org.testng.annotations.AfterTest; // For afterTest annotation
import org.testng.annotations.BeforeTest; // For beforeTest annotation
import org.testng.annotations.Test; // For Test annotation
import org.testng.SkipException; // For SkipException

public class Activity2 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefox().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testCase2() {
        //This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}