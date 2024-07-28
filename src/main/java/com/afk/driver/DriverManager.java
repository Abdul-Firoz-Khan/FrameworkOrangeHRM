package com.afk.driver;

import org.openqa.selenium.WebDriver;

/**
 * The DriverManager class provides thread-safe access to WebDriver instances using a ThreadLocal variable.
 * This ensures that each thread has its own instance of WebDriver, preventing concurrency issues in parallel test execution.
 * The class includes methods to get and set the WebDriver instance for the current thread.
 */
public final class DriverManager {

    // Private constructor to prevent instantiation
    private DriverManager() {}

    // ThreadLocal variable to hold the WebDriver instance for each thread
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * Returns the WebDriver instance associated with the current thread.
     *
     * @return The WebDriver instance for the current thread, or null if not set.
     */
    public static WebDriver getDriver() {
        return THREAD_LOCAL.get();
    }

    /**
     * Sets the WebDriver instance for the current thread.
     *
     * @param driver The WebDriver instance to associate with the current thread.
     */
    public static void setDriver(WebDriver driver) {
        THREAD_LOCAL.set(driver);
    }
}
