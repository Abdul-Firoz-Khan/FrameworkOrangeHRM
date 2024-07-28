package com.afk;

import com.afk.driver.DriverManager;
import com.afk.pages.LoginPageOrangeHRM;
import com.afk.testdata.TestData;
import com.afk.utils.DataProviderUtils;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * OrangeHRMLoginTest class is responsible for testing the login functionality of the OrangeHRM application.
 * It uses TestNG for test case management and Allure for reporting. The test data is provided by the
 * DataProviderUtils class, which reads from an external source.
 */
public class OrangeHRMLoginTest extends BaseTest {

    /**
     * Test method to verify the login functionality of OrangeHRM.
     * This test retrieves data from the DataProvider and uses it to perform a login operation.
     *
     * @param testData The TestData object containing the data for the test case.
     */
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    @Description("Test Description: This test is to verify the login functionality of OrangeHRM")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("AFK")
    public void loginTest(TestData testData) {
        WebDriver driver = DriverManager.getDriver();

        LoginPageOrangeHRM loginPage = new LoginPageOrangeHRM();
        titleValidatingTest(driver, loginPage, testData.getUsername(), testData.getPassword(), testData.getExpectedTitle());
    }

    /**
     * Private method to perform the login operation and validate the page title.
     *
     * @param driver       The WebDriver instance.
     * @param loginPage    The LoginPageOrangeHRM instance for interacting with the login page.
     * @param username     The username for login.
     * @param password     The password for login.
     * @param expectedTitle The expected title after login.
     */
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
