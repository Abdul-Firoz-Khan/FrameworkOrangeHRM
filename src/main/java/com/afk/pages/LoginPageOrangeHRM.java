package com.afk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.afk.utils.SeleniumUtils.*;

public class LoginPageOrangeHRM {
    private static final By TXTBOX_USERNAME = By.xpath("//*[@placeholder='Username']");
    private static final By TXTBOX_PASSWORD = By.xpath("//*[@placeholder='Password']");
    private static final By BTN_LOGIN = By.xpath("//*[text()=' Login ']");

    private LoginPageOrangeHRM setTxtUsername(WebDriver driver, String username) {
        visible(driver, TXTBOX_USERNAME, username, "Username TextBox");
        return this;
    }

    private LoginPageOrangeHRM setTxtPassword(WebDriver driver, String password) {
        visible(driver, TXTBOX_PASSWORD, password, "Password TextBox");
        return this;
    }

    private HomePageOrangeHRM setBtnLogin(WebDriver driver) {
        click(driver, BTN_LOGIN, "Login Button");
        return new HomePageOrangeHRM();
    }

    public HomePageOrangeHRM loginToApplication(WebDriver driver, String username, String password) {
        return setTxtUsername(driver, username).setTxtPassword(driver, password).setBtnLogin(driver);
    }

}
