package com.afk.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The LocalDriveFactory class provides a method to create WebDriver instances for local execution.
 * It uses WebDriverManager to manage the setup of WebDriver binaries for various browsers.
 * The getLocalDriver method returns a WebDriver instance based on the specified browser type.
 */
public final class LocalDriveFactory {

    // Private constructor to prevent instantiation
    private LocalDriveFactory() {
    }

    /**
     * Returns a WebDriver instance based on the specified browser type for local execution.
     *
     * @param browser The name of the browser for which the WebDriver instance should be created.
     *                Supported values are "chrome", "firefox", and "edge".
     * @return The WebDriver instance for the specified browser.
     */
    public static @NotNull WebDriver getLocalDriver(String browser) {
        WebDriver driver = null;

        // Initialize the WebDriver based on the specified browser
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup(); // Setup WebDriver for Edge browser
            driver = new EdgeDriver(); // Initialize EdgeDriver
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup(); // Setup WebDriver for Firefox browser
            driver = new FirefoxDriver(); // Initialize FirefoxDriver
        } else {
            WebDriverManager.chromedriver().setup(); // Setup WebDriver for Chrome browser
            driver = new ChromeDriver(); // Initialize ChromeDriver
        }

        return driver;
    }
}
