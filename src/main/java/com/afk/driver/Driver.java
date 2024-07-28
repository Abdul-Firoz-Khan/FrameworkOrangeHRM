package com.afk.driver;

import com.afk.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * The Driver class is responsible for managing the WebDriver instance in the framework.
 * It provides methods to initialize and quit the WebDriver, ensuring that browser sessions are properly managed.
 * This class is designed to be a utility class with a private constructor to prevent instantiation.
 */
public final class Driver {

    // Private constructor to prevent instantiation
    private Driver() {}

    /**
     * Initializes the WebDriver instance based on the configuration settings.
     * If the WebDriver is not already initialized, this method sets up the WebDriver,
     * maximizes the browser window, navigates to the specified URL, and sets the page load timeout.
     */
    public static void initDriver() {
        String browser = ConfigFactory.getConfig().browser();
        String runmode = ConfigFactory.getConfig().runmode();
        if (DriverManager.getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(runmode, browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        }
    }

    /**
     * Quits the WebDriver instance if it is not already null, closing the browser and cleaning up resources.
     * After quitting the WebDriver, the instance is set to null.
     */
    public static void quiteDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
