package Project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

    public class Task2 {
        private AndroidDriver<AndroidElement> driver;

        @BeforeTest
        public void setup() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Your_Device_Name");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.keep");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.keep.activities.BrowseActivity");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(appiumServerURL, caps);
        }

        @Test
        public void addNoteInGoogleKeep() {
            // Click the Create New Note button
            driver.findElementById("com.google.android.keep:id/new_note_button").click();

            // Add a title for the note
            MobileElement titleField = driver.findElementById("com.google.android.keep:id/editable_title");
            titleField.sendKeys("Sample Note Title");

            // Add a small description
            MobileElement descriptionField = driver.findElementById("com.google.android.keep:id/editable_note");
            descriptionField.sendKeys("This is a sample note description.");

            // Press the back button
            driver.pressKeyCode(AndroidKeyCode.BACK);

            // Make an assertion to ensure that the note was added
            MobileElement addedNote = driver.findElementById("com.google.android.keep:id/index_note_title");
            String noteTitle = addedNote.getText();
            Assert.assertEquals(noteTitle, "Sample Note Title");
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }
