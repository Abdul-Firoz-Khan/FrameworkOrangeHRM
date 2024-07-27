package com.afk;

import com.afk.driver.DriverManager;
import com.afk.pages.LoginPageOrangeHRM;
import com.afk.testdata.TestData;
import com.afk.utils.DataProviderUtils;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMLoginTest extends BaseTest {

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    @Description("Test Description: This test is to verify the login functionality of OrangeHRM")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("AFK")
    public void loginTest(TestData testData) {
        WebDriver driver = DriverManager.getDriver();

        LoginPageOrangeHRM loginPage = new LoginPageOrangeHRM();
        titleValidatingTest(driver, loginPage, testData.getUsername(), testData.getPassword(), testData.getExpectedTitle());
    }

    @Step("Perform login with username: {username} and verify the title")
    private void titleValidatingTest(WebDriver driver, LoginPageOrangeHRM loginPage, String username, String password, String expectedTitle) {
        String actualTitle = loginPage
                .loginToApplication(driver, username, password)
                .getHomePageTitle();

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
