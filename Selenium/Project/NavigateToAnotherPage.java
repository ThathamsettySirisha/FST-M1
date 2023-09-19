package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateToAnotherPage {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver",  "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testNavigateToJobsPage() {
            // Find the navigation bar
            WebElement navBar = driver.findElement(By.cssSelector(".navbar"));

            // Select the menu item that says "Jobs" and click it
            WebElement jobsMenuItem = navBar.findElement(By.linkText("Jobs"));
            jobsMenuItem.click();

            // Read the page title and verify that you are on the correct page
            String actualTitle = driver.getTitle();
            String expectedTitle = "Jobs – Alchemy Jobs";
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match the expected title.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

