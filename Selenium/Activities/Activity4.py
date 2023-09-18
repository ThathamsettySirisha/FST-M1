from selenium import webdriver

# Set the path to ChromeDriver
chrome_driver_path = "C:/Users/001ZXG744/IdeaProjects/chrome-win64/chromedriver.exe"

# Initialize WebDriver
driver = webdriver.Chrome(executable_path=chrome_driver_path)

# Open the webpage
driver.get("https://v1.training-support.net/selenium/target-practice")

# Get and print the title of the page
page_title = driver.title
print("Page Title:", page_title)

# Find the 3rd header using XPath and print its text
third_header = driver.find_element_by_xpath("(//h3)[3]")
print("3rd Header Text:", third_header.text)

# Find the 5th header using XPath and print its color
fifth_header = driver.find_element_by_xpath("(//h3)[5]")
print("5th Header Color:", fifth_header.value_of_css_property("color"))

# Find the violet button using other locators (e.g., class name) and print its classes
violet_button = driver.find_element_by_class_name("violet")
print("Violet Button Classes:", violet_button.get_attribute("class"))

# Find the grey button using other locators (e.g., CSS selector) and print its text
grey_button = driver.find_element_by_css_selector("button.gray")
print("Grey Button Text:", grey_button.text)

# Close the browser
driver.quit()
