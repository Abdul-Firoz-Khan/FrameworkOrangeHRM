package com.afk.utils;

import com.afk.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * ScreenshotUtils is a utility class that provides methods for capturing screenshots.
 * The screenshots are captured in Base64 format for easy integration into reports and logs.
 */
public final class ScreenshotUtils {

    // Private constructor to prevent instantiation
    private ScreenshotUtils() {}

    /**
     * Captures a screenshot of the current browser window as a Base64-encoded string.
     *
     * @return A Base64 string representing the screenshot, or null if the driver is not available or an error occurs.
     */
    public static String getScreenshotAsBase64() {
        try {
            TakesScreenshot screenshotDriver = (TakesScreenshot) DriverManager.getDriver();
            if (screenshotDriver == null) {
                return null;
            }
            return screenshotDriver.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
