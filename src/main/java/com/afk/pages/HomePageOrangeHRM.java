package com.afk.pages;

import com.afk.driver.DriverManager;

/**
 * HomePageOrangeHRM represents the home page of the OrangeHRM application.
 * This class provides methods to interact with elements on the home page,
 * such as retrieving the page title.
 */
public class HomePageOrangeHRM {

    /**
     * Retrieves the title of the home page.
     *
     * @return The title of the home page as a String.
     */
    public String getHomePageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
