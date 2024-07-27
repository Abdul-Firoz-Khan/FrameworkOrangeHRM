package com.afk.pages;

import com.afk.driver.DriverManager;

public class HomePageOrangeHRM {
    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();

}}
