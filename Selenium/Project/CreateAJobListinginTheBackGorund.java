package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAJobListinginTheBackGorund {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/wp-admin/";
        private String username = "root";
        private String password = "pa$$w0rd";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testCreateJobListingBackend() {
            // Log in to the backend
            WebElement usernameField = driver.findElement(By.id("user_login"));
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            WebElement loginButton = driver.findElement(By.id("wp-submit"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            loginButton.click();

            // Click the "Job Listings" menu item
            WebElement jobListingsMenuItem = driver.findElement(By.linkText("Job Listings"));
            jobListingsMenuItem.click();

            // Click the "Add New" button
            WebElement addNewButton = driver.findElement(By.linkText("Add New"));
            addNewButton.click();

            // Fill in the necessary details
            WebElement jobTitleField = driver.findElement(By.id("post-title-0"));
            WebElement jobDescriptionField = driver.findElement(By.className("editor-default-block-appender"));
            WebElement publishButton = driver.findElement(By.className("editor-post-publish-button__button"));

            jobTitleField.sendKeys("Software Engineer");
            jobDescriptionField.sendKeys("We are looking for a skilled Software Engineer.");
            publishButton.click();

            // Verify that the job listing was created
            WebElement jobListingMessage = driver.findElement(By.className("components-notice__content"));
            Assert.assertTrue(jobListingMessage.getText().contains("Post published"), "Job listing creation failed.");

            // Print success message
            System.out.println("Job listing created successfully.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }
