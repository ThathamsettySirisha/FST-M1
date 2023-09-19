package Project;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

    public class Task3 {
        private AppiumDriver<AndroidElement> driver;

        @BeforeTest
        public void setUp() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 7 pro");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(appiumServerURL, capabilities);
        }

        @Test
        public void testToDoList() throws InterruptedException {
            // Go to the URL
            driver.get("https://v1.training-support.net/selenium");

            // Scroll to find the To-Do List card and click it
            WebElement toDoListCard = driver.findElement(By.xpath("//android.view.View[contains(@text,'To-Do List')]"));
            toDoListCard.click();

            // Find the input field and enter tasks
            WebElement inputField = driver.findElement(By.id("taskInput"));
            inputField.sendKeys("Add tasks to list\n");
            inputField.sendKeys("Get number of tasks\n");
            inputField.sendKeys("Clear the list\n");

            // Click on each task to strike them out
            WebElement task1 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Add tasks to list']"));
            WebElement task2 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Get number of tasks']"));
            WebElement task3 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Clear the list']"));

            task1.click();
            task2.click();
            task3.click();

            // Clear the list
            WebElement clearButton = driver.findElement(By.id("clearButton"));
            clearButton.click();

            // Wait for a moment to see the cleared list (you can use proper waits as needed)

            Thread.sleep(3000);
        }

        @AfterTest
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

