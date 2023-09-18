package Activities;
import io.github.bonigarcia.wdm.WebDriverManager; // For WebDriverManager setup
import org.openqa.selenium.By; // For locating web elements
import org.openqa.selenium.WebDriver; // For WebDriver interface
import org.openqa.selenium.firefox.FirefoxDriver; // For FirefoxDriver
import org.testng.Assert; // For assertion
import org.testng.annotations.AfterMethod; // For afterMethod annotation
import org.testng.annotations.BeforeMethod; // For beforeMethod annotation
import org.testng.annotations.Test; // For Test annotation

public class Activity1 {
       // Declare the WebDriver object
        WebDriver driver;

        @BeforeMethod
        public void beforeMethod() {
            // Set up the Firefox driver
            WebDriverManager.firefox().setup();
            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();

            //Open browser
            driver.get("https://v1.training-support.net");
        }

        @Test
        public void exampleTestCase() {
            // Check the title of the page
            String title = driver.getTitle();

            //Print the title of the page
            System.out.println("Page title is: " + title);

            //Assertion for page title
            Assert.assertEquals("Training Support", title);

            //Find the clickable link on the page and click it
            driver.findElement(By.id("about-link")).click();

            //Print title of new page
            System.out.println("New page title is: " + driver.getTitle());

            Assert.assertEquals(driver.getTitle(), "About Training Support");
        }

        @AfterMethod
        public void afterMethod() {
            //Close the browser
            driver.quit();
        }

    }

