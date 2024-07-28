package com.afk.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager is a utility class that manages the ExtentTest instances for reporting.
 * It uses ThreadLocal to ensure thread safety, allowing each thread to have its own
 * instance of ExtentTest.
 */
public final class ExtentManager {
    private ExtentManager() {
        // Private constructor to prevent instantiation
    }

    // ThreadLocal to hold ExtentTest instances for each thread
    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    /**
     * Retrieves the ExtentTest instance for the current thread.
     *
     * @return The ExtentTest instance for the current thread.
     */
    static ExtentTest getExtentTest() {
        return threadLocal.get();
    }

    /**
     * Sets the ExtentTest instance for the current thread.
     *
     * @param test The ExtentTest instance to set for the current thread.
     */
    static void setExtentTest(ExtentTest test) {
        threadLocal.set(test);
    }
}
