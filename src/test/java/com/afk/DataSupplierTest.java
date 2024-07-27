package com.afk;

import com.afk.testdata.TestData;
import com.afk.utils.DataProviderUtils;
import org.testng.annotations.Test;

public class DataSupplierTest {



    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void dataSupplierTest(TestData testData) {
        System.out.println("Username: " + testData.getUsername());
        System.out.println("Password: " + testData.getPassword());
        System.out.println("Expected Title: " + testData.getExpectedTitle());
    }
}
