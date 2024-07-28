package com.afk.reports;

import com.afk.utils.ScreenshotUtils; // Ensure this import is correct
import com.aventstack.extentreports.MediaEntityBuilder;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

/**
 * ExtentLogger is a utility class for logging test results to ExtentReports and Allure.
 * This class includes methods to log information, pass, and fail statuses with optional screenshots.
 */
public final class ExtentLogger {

    private ExtentLogger() {
        // Private constructor to prevent instantiation
    }

    /**
     * Logs a passed test case with a message and optional screenshot.
     *
     * @param message The message to log.
     */
    public static void pass(String message) {
        logWithScreenshot(message, Status.PASSED);
    }

    /**
     * Logs a failed test case with a message and screenshot.
     *
     * @param message    The message to log.
     * @param screenshot The screenshot in Base64 format.
     */
    public static void fail(String message, String screenshot) {
        logWithScreenshot(message, Status.FAILED);
    }

    /**
     * Logs an informational message with optional screenshot.
     *
     * @param message The message to log.
     */
    public static void info(String message) {
        logWithScreenshot(message, Status.PASSED); // or Status.INFO, depending on your needs
    }

    /**
     * Logs a message with a screenshot and status to both ExtentReports and Allure.
     *
     * @param message      The message to log.
     * @param allureStatus The status to log (e.g., PASSED, FAILED).
     */
    private static void logWithScreenshot(String message, Status allureStatus) {
        String screenshot = ScreenshotUtils.getScreenshotAsBase64(); // Updated method call
        if (screenshot == null) {
            screenshot = ""; // Provide a placeholder if screenshot is null
        }
        ExtentManager.getExtentTest().log(
                allureStatus == Status.FAILED ? com.aventstack.extentreports.Status.FAIL :
                        (allureStatus == Status.PASSED ? com.aventstack.extentreports.Status.PASS :
                                com.aventstack.extentreports.Status.INFO),
                message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build()
        );
        Allure.step(message, allureStatus);
    }
}
