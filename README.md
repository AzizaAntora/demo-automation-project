# Selenium Maven Project

This is a Java Selenium project managed with Maven for automated testing of web applications.

## Prerequisites

- Java JDK 8 or higher
- Maven 3.3 or higher
- WebDriver (ChromeDriver, GeckoDriver, etc.) compatible with your browser version

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/selenium-maven-project.git

2. Navigate to the project directory:

   ```bash
   cd selenium-maven-project
   
3. Download the necessary dependencies using Maven:

   ```bash
   mvn clean install


## Configuration   

1. Update the WebDriver executable path in the src/test/resources/config.properties file:

   ```bash
   webdriver.chrome.driver=/path/to/chromedriver
   
2. Modify other configurations in the src/test/resources/config.properties file as needed.

## Running Tests

Execute the following Maven command to run the tests:
```bash
   mvn test


## Test Reports
After running the tests, you can find the test reports in the `target-output` directory.