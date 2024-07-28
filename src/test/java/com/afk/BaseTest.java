package com.afk;

import com.afk.driver.Driver;
import com.afk.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;

/**
 * BaseTest serves as the base class for all test classes in the framework.
 * It includes setup and teardown methods that are executed before and after each test method and test suite.
 * The class handles the initialization and cleanup of the WebDriver, as well as the setup and finalization of test reports.
 */
public class BaseTest {

    /**
     * Initializes the ExtentReports at the beginning of the test suite.
     */
    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initReport();
    }

    /**
     * Flushes the ExtentReports at the end of the test suite.
     */
    @AfterSuite
    public void afterSuite() {
        ExtentReport.flushReports();
    }

    /**
     * Sets up the test environment before each test method, including creating a test report entry
     * and initializing the WebDriver.
     *
     * @param method The test method that is being executed.
     */
    @BeforeMethod
    public void setUp(Method method) {
        ExtentReport.createTest(method.getName());
        Driver.initDriver();
    }

    /**
     * Cleans up the test environment after each test method, including quitting the WebDriver.
     */
    @AfterMethod
    public void tearDown() {
        Driver.quiteDriver();
    }
}
