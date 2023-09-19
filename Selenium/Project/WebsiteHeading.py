import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By

class WebsiteHeading(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox(executable_path="C:/Users/001ZXG744/IdeaProjects/geckodriver.exe")
        self.base_url = "https://alchemy.hguy.co/jobs/"

    def test_website_heading(self):
        # Navigate to the base URL
        self.driver.get(self.base_url)

        # Get the heading of the webpage
        heading_element = self.driver.find_element(By.XPATH, "//h1[@class='entry-title']")
        actual_heading = heading_element.text

        # Verify the heading matches the expected heading
        expected_heading = "Welcome to Alchemy Jobs"
        self.assertEqual(actual_heading, expected_heading, "Website heading does not match the expected heading.")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
