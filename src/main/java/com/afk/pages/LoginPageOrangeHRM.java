package com.afk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.afk.utils.SeleniumUtils.*;

/**
 * LoginPageOrangeHRM represents the login page of the OrangeHRM application.
 * This class provides methods to interact with the login page elements and perform the login operation.
 */
public class LoginPageOrangeHRM {
    private static final By TXTBOX_USERNAME = By.xpath("//*[@placeholder='Username']");
    private static final By TXTBOX_PASSWORD = By.xpath("//*[@placeholder='Password']");
    private static final By BTN_LOGIN = By.xpath("//*[text()=' Login ']");

    /**
     * Sets the username in the username text box.
     *
     * @param driver   The WebDriver instance used to interact with the browser.
     * @param username The username to be entered.
     * @return The current instance of LoginPageOrangeHRM.
     */
    private LoginPageOrangeHRM setTxtUsername(WebDriver driver, String username) {
        visible(driver, TXTBOX_USERNAME, username, "Username TextBox");
        return this;
    }

    /**
     * Sets the password in the password text box.
     *
     * @param driver   The WebDriver instance used to interact with the browser.
     * @param password The password to be entered.
     * @return The current instance of LoginPageOrangeHRM.
     */
    private LoginPageOrangeHRM setTxtPassword(WebDriver driver, String password) {
        visible(driver, TXTBOX_PASSWORD, password, "Password TextBox");
        return this;
    }

    /**
     * Clicks the login button.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     * @return An instance of HomePageOrangeHRM, representing the home page after a successful login.
     */
    private HomePageOrangeHRM setBtnLogin(WebDriver driver) {
        click(driver, BTN_LOGIN, "Login Button");
        return new HomePageOrangeHRM();
    }

    /**
     * Logs in to the OrangeHRM application using the provided username and password.
     *
     * @param driver   The WebDriver instance used to interact with the browser.
     * @param username The username for login.
     * @param password The password for login.
     * @return An instance of HomePageOrangeHRM, representing the home page after a successful login.
     */
    public HomePageOrangeHRM loginToApplication(WebDriver driver, String username, String password) {
        return setTxtUsername(driver, username).setTxtPassword(driver, password).setBtnLogin(driver);
    }
}
