import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

class Task1VerifyWebsiteTitle(unittest.TestCase):
    def setUp(self):
        # Set up the Firefox driver
        self.driver = webdriver.Firefox()

    def test_verify_website_title(self):
        # Navigate to the website
        self.driver.get("https://alchemy.hguy.co/jobs")

        # Get the title of the website
        website_title = self.driver.title

        # Verify the title matches the expected title
        expected_title = "Alchemy Jobs – Job Board Application"
        self.assertEqual(website_title, expected_title, f"Expected title: {expected_title}, Actual title: {website_title}")

    def tearDown(self):
        # Close the browser
        self.driver.close()

if __name__ == "__main__":
    unittest.main()
