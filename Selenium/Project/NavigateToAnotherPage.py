import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

class NavigateToAnotherPage(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox(executable_path="C:/Users/001ZXG744/IdeaProjects/geckodriver.exe")
        self.base_url = "https://alchemy.hguy.co/jobs/"

    def test_navigate_to_jobs_page(self):
        # Navigate to the base URL
        self.driver.get(self.base_url)

        # Find the navigation bar
        nav_bar = self.driver.find_element(By.CSS_SELECTOR, ".navbar")

        # Select the menu item that says "Jobs" and click it
        jobs_menu_item = nav_bar.find_element(By.LINK_TEXT, "Jobs")
        jobs_menu_item.click()

        # Wait for the page to load (you can also use WebDriverWait for more robust waiting)
        time.sleep(2)

        # Read the page title and verify that you are on the correct page
        actual_title = self.driver.title
        expected_title = "Jobs – Alchemy Jobs"
        self.assertEqual(actual_title, expected_title, "Page title does not match the expected title.")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
