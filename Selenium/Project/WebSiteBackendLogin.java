package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebSiteBackendLogin {
        private WebDriver driver;
        private String baseUrl = "https://alchemy.hguy.co/jobs/wp-admin/";
        private String username = "root";
        private String password = "pa$$w0rd";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver",  "C://Users//001ZXG744//IdeaProjects//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }

        @Test
        public void testLoginToBackend() {
            // Find the username field and enter the username
            WebElement usernameField = driver.findElement(By.id("user_login"));
            usernameField.sendKeys(username);

            // Find the password field and enter the password
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            passwordField.sendKeys(password);

            // Find the login button and click it
            WebElement loginButton = driver.findElement(By.id("wp-submit"));
            loginButton.click();

            // Verify that you have logged in by checking for the presence of the WordPress dashboard
            WebElement dashboardHeader = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
            Assert.assertNotNull(dashboardHeader, "Login to backend failed.");

            // Print success message
            System.out.println("Logged in to the backend successfully.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

