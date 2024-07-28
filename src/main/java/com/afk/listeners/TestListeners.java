package com.afk.listeners;

import com.afk.reports.ExtentLogger;
import com.afk.reports.ExtentReport;
import com.afk.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

/**
 * TestListeners is an implementation of the ITestListener interface from TestNG.
 * It provides hooks that are called during the lifecycle of a test, such as when a test starts,
 * succeeds, or fails. This class integrates with the ExtentReports library to log test information
 * and capture screenshots on failure.
 */
public class TestListeners implements ITestListener {

    /**
     * Called when a test starts. This method initializes a new test entry in the ExtentReports.
     *
     * @param result The ITestResult object containing information about the test.
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
    }

    /**
     * Called when a test succeeds. This method logs the test name and success status to ExtentReports.
     *
     * @param result The ITestResult object containing information about the test.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success message without attaching a screenshot
        ExtentLogger.pass(result.getName() + " is passed");
    }

    /**
     * Called when a test fails. This method captures a screenshot and logs the failure details,
     * including the exception message and stack trace, to ExtentReports.
     *
     * @param result The ITestResult object containing information about the test.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        // Capture a screenshot and log failure details
        String screenshot = ScreenshotUtils.getScreenshotAsBase64();
        if (screenshot != null) {
            ExtentLogger.fail("Screenshot of failure", screenshot);
        }

        // Log the exception message and stack trace
        ExtentLogger.fail(result.getThrowable().getMessage(), screenshot);
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()), screenshot);
    }

    /**
     * Called before any tests are run. This method initializes the ExtentReports.
     *
     * @param context The ITestContext object containing information about the test run.
     */
    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }

    /**
     * Called after all the tests have run. This method finalizes and flushes the ExtentReports.
     *
     * @param context The ITestContext object containing information about the test run.
     */
    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
