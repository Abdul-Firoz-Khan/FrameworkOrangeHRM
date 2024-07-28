package com.afk.reports;

import com.afk.contants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * ExtentReport is a utility class that handles the initialization and management
 * of ExtentReports, including creating tests and flushing the reports to disk.
 * It leverages ExtentSparkReporter for generating interactive HTML reports.
 */
public final class ExtentReport {
    private ExtentReport() {
        // Private constructor to prevent instantiation
    }

    // Static instances of ExtentReports and ExtentTest
    public static ExtentReports extent;
    public static ExtentTest extentTest;

    /**
     * Initializes the ExtentReports instance and attaches an ExtentSparkReporter
     * to it for generating HTML reports.
     */
    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extent.attachReporter(spark);
    }

    /**
     * Flushes the ExtentReports instance, ensuring all the logs are written to the
     * report file.
     */
    public static void flushReports() {
        extent.flush();
    }

    /**
     * Creates a new test in the ExtentReports instance and sets it in the ExtentManager
     * for the current thread.
     *
     * @param testCaseName The name of the test case to create.
     */
    public static void createTest(String testCaseName) {
        extentTest = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(extentTest);
    }
}
