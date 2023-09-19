package Project;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebsiteHeading {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver",  "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testWebsiteHeading() {
            // Get the heading of the webpage
            WebElement headingElement = driver.findElement(By.xpath("//h1[@class='entry-title']"));
            String actualHeading = headingElement.getText();

            // Verify the heading matches the expected heading
            String expectedHeading = "Welcome to Alchemy Jobs";
            Assert.assertEquals(actualHeading, expectedHeading, "Website heading does not match the expected heading.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }
