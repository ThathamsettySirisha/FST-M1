package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchAndApplyForJob {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver",  "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testSearchAndApplyForJob() {
            // Navigate to the Jobs page
            WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
            jobsMenuItem.click();

            // Search for a particular job
            WebElement searchInput = driver.findElement(By.id("search_keywords"));
            searchInput.sendKeys("Software Engineer");

            // Click the Search button
            WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
            searchButton.click();

            // Wait for job listings to show
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("job_listing")));

            // Click and open any one of the jobs listed
            WebElement jobListing = driver.findElement(By.className("job_listing"));
            jobListing.click();

            // Click the apply button
            WebElement applyButton = driver.findElement(By.className("application_button"));
            applyButton.click();

            // Print the email to the console
            WebElement emailElement = driver.findElement(By.xpath("//div[@class='job_application_email']"));
            String email = emailElement.getText();
            System.out.println("Job Application Email: " + email);
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

