package Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task1 {

        private AndroidDriver<AndroidElement> driver;

        @BeforeTest
        public void setUp() throws MalformedURLException {

            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.android.chrome");
            options.setAppActivity("com.google.android.apps.chrome.Main");
            options.noReset();

            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(appiumServerURL, options);
        }

        @Test
        public void createTasksInGoogleTasksApp() {
            // Click the button to add a new task
            AndroidElement addTaskButton = driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab"));
            addTaskButton.click();

            // Add tasks one by one
            addTask("Complete Activity with Google Tasks");
            addTask("Complete Activity with Google Keep");
            addTask("Complete the second Activity Google Keep");

            // Click the Save button after each task is added
            AndroidElement saveButton = driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done"));
            saveButton.click();

            // Verify that all tasks are added
            Assert.assertTrue(isTaskVisible("Complete Activity with Google Tasks"));
            Assert.assertTrue(isTaskVisible("Complete Activity with Google Keep"));
            Assert.assertTrue(isTaskVisible("Complete the second Activity Google Keep"));
        }

        private void addTask(String taskName) {
            AndroidElement taskInputField = driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title"));
            taskInputField.sendKeys(taskName);
        }

        private boolean isTaskVisible(String taskName) {
            AndroidElement task = driver.findElementByAndroidUIAutomator("textContains(\"" + taskName + "\")");
            return task.isDisplayed();
        }

        @AfterTest
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
