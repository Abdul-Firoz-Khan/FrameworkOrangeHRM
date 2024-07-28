package com.afk.driver;

import com.afk.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The RemoteDriveFactory class provides a method to create WebDriver instances for remote execution.
 * It supports multiple browsers and connects to a Selenium Grid or a remote WebDriver server.
 * The getRemoteDriver method returns a WebDriver instance based on the specified browser type and
 * the configuration provided in the properties file.
 */
public class RemoteDriveFactory {
    // Private constructor to prevent instantiation
    private RemoteDriveFactory() {
    }

    /**
     * Returns a WebDriver instance for remote execution based on the specified browser type.
     *
     * @param browser The name of the browser for which the WebDriver instance should be created.
     *                Supported values are "chrome", "firefox", and "edge".
     * @return The WebDriver instance for the specified browser.
     */
    public static WebDriver getRemoteDriver(String browser) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            // Set the desired capabilities based on the specified browser
            if (browser.equalsIgnoreCase("edge")) {
                capabilities.setBrowserName("edge");
            } else if (browser.equalsIgnoreCase("firefox")) {
                capabilities.setBrowserName("firefox");
            } else if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // Create a new RemoteWebDriver instance using the remote URL from the configuration
            driver = new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteurl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid remote URL", e);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing remote driver", e);
        }

        return driver;
    }
}
