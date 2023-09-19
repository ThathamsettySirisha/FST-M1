package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAnewjoblisting {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver",  "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testCreateJobListing() {
            // Locate the navigation menu and click "Post a Job"
            WebElement postJobMenuItem = driver.findElement(By.linkText("Post a Job"));
            postJobMenuItem.click();

            // Fill in the necessary details
            WebElement jobTitleField = driver.findElement(By.id("job_title"));
            WebElement jobDescriptionField = driver.findElement(By.id("job_description"));
            WebElement applicationEmailField = driver.findElement(By.id("application"));
            WebElement companyNameField = driver.findElement(By.id("company_name"));

            jobTitleField.sendKeys("Software Engineer");
            jobDescriptionField.sendKeys("We are looking for a skilled Software Engineer.");
            applicationEmailField.sendKeys("example@example.com");
            companyNameField.sendKeys("Example Inc.");

            // Click the "Preview" button
            WebElement previewButton = driver.findElement(By.name("submit_job"));
            previewButton.click();

            // Click the "Submit Listing" button
            WebElement submitListingButton = driver.findElement(By.xpath("//input[@value='Submit Listing']"));
            submitListingButton.click();

            // Verify that the job listing was posted by visiting the jobs page
            WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
            jobsMenuItem.click();

            WebElement postedJob = driver.findElement(By.xpath("//h3[text()='Software Engineer']"));
            Assert.assertNotNull(postedJob, "Job listing was not posted.");

            // Print success message
            System.out.println("Job listing posted successfully.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

