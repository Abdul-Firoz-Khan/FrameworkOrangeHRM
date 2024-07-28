


## FrameworkOrangeHRM

FrameworkOrangeHRM is a Selenium-based automation testing framework designed for testing the OrangeHRM application. The framework uses TestNG for test execution and ExtentReports for reporting.

## Project Structure

The project is organized as follows:

- `src/main/java/com/afk/config`: Configuration classes for managing application settings.
- `src/main/java/com/afk/contants`: Constants used throughout the framework.
- `src/main/java/com/afk/driver`: WebDriver management classes.
- `src/main/java/com/afk/listeners`: Custom TestNG listeners for logging and reporting.
- `src/main/java/com/afk/pages`: Page Object Model (POM) classes for OrangeHRM.
- `src/main/java/com/afk/reports`: Reporting utilities using ExtentReports and Allure.
- `src/main/java/com/afk/testdata`: Classes representing test data models.
- `src/main/java/com/afk/utils`: Utility classes for various helper functions.

## Configuration

Configuration for the framework is handled by the `ConfigFactory` and `FrameworkConfig` classes. The `config.properties` file contains key-value pairs for various settings:

- `timeout`: The timeout value for page load (in seconds).
- `url`: The base URL of the OrangeHRM application.
- `browser`: The browser to use for testing (`chrome`, `firefox`, `edge`).
- `runmode`: The mode of test execution (`local`, `remote`).
- `remoteurl`: The URL for the remote WebDriver server (e.g., Selenium Grid).

## Installation

To use this project, follow these steps:

1. **Clone the repository**:
   ```sh
   git clone https://github.com/Abdul-Firoz-Khan/FrameworkOrangeHRM.git
   ```

2. **Install dependencies**:
   Ensure you have Maven installed. Navigate to the project directory and run:
   ```sh
   mvn clean install
   ```

## Running the Tests

### Locally

To run the tests locally, set the `runmode` in `config.properties` to `local` and specify the browser (`chrome`, `firefox`, `edge`).

Run the tests using Maven:
```sh
mvn test
```

### Remotely

To run tests on a remote Selenium Grid, set the `runmode` to `remote` and provide the `remoteurl` in `config.properties`.

## Reporting

The framework generates reports using ExtentReports and Allure:

- **ExtentReports**: A detailed HTML report is generated in the project's root directory (`index.html`).
- **Allure Reports**: You can generate Allure reports by following the [Allure documentation](https://docs.qameta.io/allure/).

## Contributors

- **Abdul Firoz Khan** - [GitHub](https://github.com/Abdul-Firoz-Khan)



