package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebsiteSecondHeading {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver",  "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testSecondHeading() {
            // Get the second heading on the page
            WebElement secondHeadingElement = driver.findElement(By.xpath("//h3[@class='entry-title']/a"));
            String actualSecondHeading = secondHeadingElement.getText();

            // Verify the second heading matches the expected text
            String expectedSecondHeading = "Quia quis non";
            Assert.assertEquals(actualSecondHeading, expectedSecondHeading, "Second heading does not match the expected text.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

