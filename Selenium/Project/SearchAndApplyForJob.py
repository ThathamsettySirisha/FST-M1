import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class SearchAndApplyForJob(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox(executable_path="C:/Users/001ZXG744/IdeaProjects/geckodriver.exe")
        self.base_url = "https://alchemy.hguy.co/jobs/"

    def test_search_and_apply_for_job(self):
        # Navigate to the Jobs page
        self.driver.get(self.base_url)
        jobs_menu_item = self.driver.find_element(By.LINK_TEXT, "Jobs")
        jobs_menu_item.click()

        # Search for a particular job
        search_input = self.driver.find_element(By.ID, "search_keywords")
        search_input.send_keys("Software Engineer")

        # Click the Search button
        search_button = self.driver.find_element(By.XPATH, "//input[@type='submit']")
        search_button.click()

        # Wait for job listings to show
        wait = WebDriverWait(self.driver, 10)
        wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "job_listing")))

        # Click and open any one of the jobs listed
        job_listing = self.driver.find_element(By.CLASS_NAME, "job_listing")
        job_listing.click()

        # Click the apply button
        apply_button = self.driver.find_element(By.CLASS_NAME, "application_button")
        apply_button.click()

        # Print the email to the console
        email_element = self.driver.find_element(By.XPATH, "//div[@class='job_application_email']")
        email = email_element.text
        print("Job Application Email: " + email)

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
