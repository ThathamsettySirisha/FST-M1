package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebsiteTitle {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testWebsiteTitle() {
            // Get the title of the website
            String actualTitle = driver.getTitle();

            // Verify the title matches the expected title
            String expectedTitle = "Alchemy Jobs – Job Board Application";
            Assert.assertEquals(actualTitle, expectedTitle, "Website title does not match the expected title.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }
