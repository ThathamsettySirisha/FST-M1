import unittest
from selenium import webdriver

class CreateNewJobListing(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox(executable_path="C:/Users/001ZXG744/IdeaProjects/geckodriver.exe")
        self.base_url = "https://alchemy.hguy.co/jobs/"

    def test_create_job_listing(self):
        # Navigate to the jobs page
        self.driver.get(self.base_url)

        # Locate the navigation menu and click "Post a Job"
        post_job_menu_item = self.driver.find_element_by_link_text("Post a Job")
        post_job_menu_item.click()

        # Fill in the necessary details
        job_title_field = self.driver.find_element_by_id("job_title")
        job_description_field = self.driver.find_element_by_id("job_description")
        application_email_field = self.driver.find_element_by_id("application")
        company_name_field = self.driver.find_element_by_id("company_name")

        job_title_field.send_keys("Software Engineer")
        job_description_field.send_keys("We are looking for a skilled Software Engineer.")
        application_email_field.send_keys("example@example.com")
        company_name_field.send_keys("Example Inc.")

        # Click the "Preview" button
        preview_button = self.driver.find_element_by_name("submit_job")
        preview_button.click()

        # Click the "Submit Listing" button
        submit_listing_button = self.driver.find_element_by_xpath("//input[@value='Submit Listing']")
        submit_listing_button.click()

        # Verify that the job listing was posted by visiting the jobs page
        jobs_menu_item = self.driver.find_element_by_link_text("Jobs")
        jobs_menu_item.click()

        posted_job = self.driver.find_element_by_xpath("//h3[text()='Software Engineer']")
        self.assertIsNotNone(posted_job, "Job listing was not posted.")

        # Print success message
        print("Job listing posted successfully.")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
