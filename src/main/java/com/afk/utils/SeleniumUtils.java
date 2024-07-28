package com.afk.utils;

import com.afk.reports.ExtentLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * SeleniumUtils provides utility methods for common Selenium WebDriver actions,
 * including sending keys to elements, clicking elements, and waiting for elements to be present.
 * It also integrates with reporting tools like ExtentReports and Allure for logging actions and capturing screenshots.
 */
public class SeleniumUtils {

    /**
     * Enters a value into a specified web element after waiting for its presence.
     *
     * @param driver      The WebDriver instance.
     * @param by          The locator for the web element.
     * @param value       The value to enter.
     * @param elementName The name of the element for reporting purposes.
     */
    @Step("Entering value: {value} into element: {elementName}")
    public static void visible(WebDriver driver, By by, String value, String elementName) {
        WebElement element = waitUntilElementIsPresent(driver, by);
        element.sendKeys(value);
        String screenshot = ScreenshotUtils.getScreenshotAsBase64();
        ExtentLogger.pass(value + " is entered successfully in " + elementName);
        if (screenshot != null) {
            ExtentLogger.pass("Screenshot after entering value into " + elementName, screenshot);
        }
    }

    /**
     * Clicks on a specified web element after waiting for its presence.
     *
     * @param driver      The WebDriver instance.
     * @param by          The locator for the web element.
     * @param elementName The name of the element for reporting purposes.
     */
    @Step("Clicking on element: {elementName}")
    public static void click(WebDriver driver, By by, String elementName) {
        WebElement element = waitUntilElementIsPresent(driver, by);
        element.click();
        String screenshot = ScreenshotUtils.getScreenshotAsBase64();
        ExtentLogger.pass(elementName + " is clicked successfully");
        if (screenshot != null) {
            ExtentLogger.pass("Screenshot after clicking on " + elementName, screenshot);
        }
    }

    /**
     * Waits until the specified web element is present in the DOM.
     *
     * @param driver The WebDriver instance.
     * @param by     The locator for the web element.
     * @return The WebElement once it is present.
     */
    private static WebElement waitUntilElementIsPresent(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
