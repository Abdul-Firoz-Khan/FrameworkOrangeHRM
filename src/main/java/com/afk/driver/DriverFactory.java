package com.afk.driver;

import org.openqa.selenium.WebDriver;

/**
 * The DriverFactory class is responsible for creating WebDriver instances based on the specified run mode and browser type.
 * It provides a centralized method to obtain the appropriate WebDriver instance for both local and remote execution.
 * This class is designed to be a utility class with a private constructor to prevent instantiation.
 */
public final class DriverFactory {

    // Private constructor to prevent instantiation
    private DriverFactory() {}

    /**
     * Returns a WebDriver instance based on the specified run mode and browser name.
     * If the run mode is "local", it obtains a local WebDriver instance from LocalDriveFactory.
     * If the run mode is "remote", it obtains a remote WebDriver instance from RemoteDriveFactory.
     *
     * @param runmode     The mode in which the tests will run (e.g., "local" or "remote").
     * @param browserName The name of the browser to use (e.g., "chrome", "firefox", "edge").
     * @return A WebDriver instance for the specified run mode and browser.
     */
    public static WebDriver getDriver(String runmode, String browserName) {
        WebDriver driver = null;
        if (runmode.equalsIgnoreCase("local")) {
            driver = LocalDriveFactory.getLocalDriver(browserName);
        } else if (runmode.equalsIgnoreCase("remote")) {
            driver = RemoteDriveFactory.getRemoteDriver(browserName);
        }
        return driver;
    }
}
