import unittest
from selenium import webdriver

class CreateJobListingInBackground(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.base_url = "https://alchemy.hguy.co/jobs/wp-admin/"
        self.username = "root"
        self.password = "pa$$w0rd"

    def test_create_job_listing_backend(self):
        # Log in to the backend
        self.driver.get(self.base_url)
        username_field = self.driver.find_element_by_id("user_login")
        password_field = self.driver.find_element_by_id("user_pass")
        login_button = self.driver.find_element_by_id("wp-submit")

        username_field.send_keys(self.username)
        password_field.send_keys(self.password)
        login_button.click()

        # Click the "Job Listings" menu item
        job_listings_menu_item = self.driver.find_element_by_link_text("Job Listings")
        job_listings_menu_item.click()

        # Click the "Add New" button
        add_new_button = self.driver.find_element_by_link_text("Add New")
        add_new_button.click()

        # Fill in the necessary details
        job_title_field = self.driver.find_element_by_id("post-title-0")
        job_description_field = self.driver.find_element_by_class_name("editor-default-block-appender")
        publish_button = self.driver.find_element_by_class_name("editor-post-publish-button__button")

        job_title_field.send_keys("Software Engineer")
        job_description_field.send_keys("We are looking for a skilled Software Engineer.")
        publish_button.click()

        # Verify that the job listing was created
        job_listing_message = self.driver.find_element_by_class_name("components-notice__content")
        self.assertTrue("Post published" in job_listing_message.text, "Job listing creation failed.")

        # Print success message
        print("Job listing created successfully.")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
