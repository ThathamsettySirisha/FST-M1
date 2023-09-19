import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By

class WebsiteSecondHeading(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox(executable_path="C:/Users/001ZXG744/IdeaProjects/geckodriver.exe")
        self.base_url = "https://alchemy.hguy.co/jobs/"

    def test_second_heading(self):
        # Navigate to the base URL
        self.driver.get(self.base_url)

        # Get the second heading on the page
        second_heading_element = self.driver.find_element(By.XPATH, "//h3[@class='entry-title']/a")
        actual_second_heading = second_heading_element.text

        # Verify the second heading matches the expected text
        expected_second_heading = "Quia quis non"
        self.assertEqual(actual_second_heading, expected_second_heading, "Second heading does not match the expected text.")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
