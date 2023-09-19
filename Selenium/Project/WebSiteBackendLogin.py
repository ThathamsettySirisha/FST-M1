import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

class WebSiteBackendLogin(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox(executable_path="C:/Users/001ZXG744/IdeaProjects/geckodriver.exe")
        self.base_url = "https://alchemy.hguy.co/jobs/wp-admin/"
        self.username = "root"
        self.password = "pa$$w0rd"

    def test_login_to_backend(self):
        # Navigate to the backend login page
        self.driver.get(self.base_url)

        # Find the username field and enter the username
        username_field = self.driver.find_element(By.ID, "user_login")
        username_field.send_keys(self.username)

        # Find the password field and enter the password
        password_field = self.driver.find_element(By.ID, "user_pass")
        password_field.send_keys(self.password)

        # Find the login button and click it
        login_button = self.driver.find_element(By.ID, "wp-submit")
        login_button.click()

        # Verify that you have logged in by checking for the presence of the WordPress dashboard
        dashboard_header = self.driver.find_element(By.XPATH, "//h1[text()='Dashboard']")
        self.assertIsNotNone(dashboard_header, "Login to backend failed.")

        # Print success message
        print("Logged in to the backend successfully.")

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()
