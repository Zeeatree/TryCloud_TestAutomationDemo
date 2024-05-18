# TryCloud Test Automation Demo

***

## Overview

This project is a UI test automation demo for TryCloud, a cloud-based collaboration software. The project is built using
Java and Maven, and leverages Selenium for browser automation. The tests are written in a Behavior-Driven Development (
BDD) style using Cucumber, which allows for easy understanding of the test scenarios. The project also uses the JUnit
testing framework, a popular choice for testing in Java applications. Maven is used for dependency management and build
automation.

***

## Features

- **Behavior-Driven Development (BDD):** Tests are written in an easy-to-understand BDD style using Cucumber.
- **Browser Automation:** Utilizes Selenium for automating browser actions.
- **JUnit Integration:** Tests are executed using the JUnit framework.
- **Dependency Management:** Maven manages project dependencies and build configurations.
- **Logging:** Log4j is used for logging test execution details.
- **Data Generation:** JavaFaker is used to generate fake data for tests.
- **Browser Driver Management:** WebDriverManager handles the management of browser drivers required by Selenium.
- **Parallel Testing:** Implemented using the Maven Surefire plugin to run tests concurrently, improving test execution
  time.
- **Pretty HTML Reports:** Generates comprehensive and visually appealing HTML reports for test results.

***

## Design Patterns

### Page Object Model (POM)

The project follows the Page Object Model (POM) design pattern for creating page classes.

**Advantages of POM:**

- **Code Reusability:** Reduces code duplication by creating reusable page components.
- **Maintainability:** Easier to update and maintain tests when UI changes occur.
- **Readability:** Enhances test readability by separating test logic from page structure.

### Singleton Design Pattern

The Singleton design pattern is used for the WebDriver instance.

**Benefits of Singleton Design Pattern:**

- **Single Instance:** Ensures a single instance of WebDriver is created, avoiding multiple browser instances.
- **Resource Management:** Optimizes resource usage by reusing the same WebDriver instance.
- **Thread Safety:** Facilitates thread safety in parallel test execution scenarios.

***

## Test Scenarios

The project includes a variety of tests to ensure the application's functionality is thoroughly verified. The test
scenarios are organized into different user stories, each addressing specific functionalities:

### User Story 1: Login Functionality

1. I should be able to log in with a valid username and password.
2. I should not be able to log in with an invalid username or password.
3. I should not be able to log in with an empty username or password.
4. I should see the password as dots when I enter it.
5. I should see the forgot password link.

### User Story 2: Post-Login Navigation

1. User should be able to see the module after login.
2. User should be able to see the following modules after login:
    - Files
    - Activity
    - Gallery
    - Talk
    - Calendar
    - Deck
    - Announcement
3. User should be able to see the username after login.
4. User should be able to see the search box after login.
5. User should be able to see the notifications after login.
6. User should be able to see the user icon after login.
7. User should be able to see the profile and settings after clicking on the user icon.

### User Story 3: Personal Information Management

1. User can see at least the following titles inside personal info under Full name/Email/Phone Number:
    - Full name
    - Email
    - Phone number
    - Address
    - Website
    - Twitter
    - Language
    - Locale
    - Profile picture
2. User can change "Full name" info under Profile Settings page.
3. User can make "Phone number" info private under Profile Settings page.
4. User can see the current local time under the Local dropdown.
5. User can change profile picture.
6. User can change language settings.
7. User can delete their account.

### User Story 4: File Management

1. User should be able to upload a file to a folder.
2. User should be able to create a new folder.
3. User should be able to move any item to any folder.
4. User should be able to copy any item to any folder.
5. User should be able to delete any item.
6. User should be able to see the total number of files and folders under the files list table.

***

## Project Structure

- **src/test/java:** Contains the step definitions, runners, utilities, hooks, and page objects for the Cucumber tests.
- **src/test/resources:** Contains the feature files with the BDD test scenarios.
- **pom.xml:** Maven configuration file that manages dependencies and plugins.

***

## Dependencies

The `pom.xml` file includes the following dependencies:

- **Selenium:** For browser automation.
- **JUnit:** For running the tests.
- **Cucumber:** For BDD style test definitions.
- **Log4j:** For logging.
- **WebDriverManager:** For managing browser drivers.
- **JavaFaker:** For generating fake data for tests.
- **Maven Surefire Plugin:** For running tests, with configuration for parallel test execution.
- **Cucumber HTML Reporter:** For generating pretty HTML reports of test results.

***

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Zeeatree/trycloud-test-automation.git
   cd trycloud-test-automation
   ```

2. **Install dependencies:**
   ```sh
   mvn clean install
   ```

3. **Run the tests:**
   ```sh
   mvn test
   ```

***

## Acknowledgments

- Thanks to the Selenium, JUnit, Cucumber, Log4j, and JavaFaker communities for their great tools and libraries.
- Special thanks to the TryCloud team for their software and support.

---