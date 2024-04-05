# Selenium Framework for Demo Banking Application

This repository contains a Selenium framework developed using Java and Maven for automating tests on a simplified demo banking application available at [https://demo.guru99.com/v4/](https://demo.guru99.com/v4/).

## Overview

The Selenium framework aims to automate testing for the demo banking application, covering various functionalities such as login, account management, transactions, and more. The framework incorporates features such as assertions, reporting, and screenshots for comprehensive test automation.

## Features

- **Maven Structure**: The project follows a Maven structure for dependency management and build automation, ensuring easy setup and maintenance.

- **TestNG Integration**: TestNG is used for test case management, allowing for organized test suites, parallel execution, and detailed test reports.

- **Assertions**: Assertions are implemented to validate expected outcomes, ensuring the correctness of application behavior during testing.

- **Reporting**: Extent Reports are integrated to generate detailed and visually appealing test reports, providing insights into test execution and results.

- **Screenshots**: Screenshots are captured during test failures to provide visual evidence and aid in debugging.

## Setup Instructions

1. Clone the repository to your local machine:
   ```
   git clone https://github.com/0MuhammadAbdullah0/selenium-framework.git
   ```

2. Ensure you have Java Development Kit (JDK) and Maven installed on your system.

3. Update the necessary dependencies in the `pom.xml` file if required.

4. Configure the test data and login credentials in the test scripts or external configuration files.

5. Run the test suite using Maven:
   ```
   mvn test
   ```

## Directory Structure

- **src/main/java**: Contains Java source files for the framework implementation.
- **src/main/resources**: Configuration files, such as log4j properties and test data.
- **src/test/java**: TestNG test classes for automated test scenarios.
- **src/test/resources**: TestNG XML files, screenshots, and other test resources.

## Test Scenarios

The following test scenarios are covered in the framework:

1. **Login Functionality**: Tests for logging into the banking application using valid and invalid credentials.
2. **Account Management**: Tests for account creation, deletion, and modification functionalities.
3. **Transaction Processing**: Tests for deposit, withdrawal, and fund transfer operations.
4. **Error Handling**: Tests for handling error conditions gracefully, such as incorrect login attempts or insufficient balance.

## Contributors

- [Muhammad Abdullah](https://github.com/0MuhammadAbdullah0)




## Acknowledgments

- Special thanks to [Demo Website](https://demo.guru99.com/v4/) for providing a platform for testing automation.
- Thanks to the open-source community for their contributions to Selenium, TestNG, Extent Reports, and other libraries used in this project.
