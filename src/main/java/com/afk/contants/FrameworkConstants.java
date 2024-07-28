package com.afk.contants;

/**
 * The FrameworkConstants class provides a central place to define and access
 * constants used throughout the automation framework. This class is designed
 * to be a utility class, hence it has a private constructor to prevent instantiation.
 */
public final class FrameworkConstants {

    // Private constructor to prevent instantiation
    private FrameworkConstants() {}

    /**
     * The REPORT_PATH constant defines the file path for the generated test report.
     * The path is dynamically set based on the current user's working directory.
     */
    private static final String REPORT_PATH = System.getProperty("user.dir") + "/index.html";

    /**
     * Returns the file path where the test report will be saved.
     *
     * @return the report file path as a String
     */
    public static String getReportPath() {
        return REPORT_PATH;
    }
}
