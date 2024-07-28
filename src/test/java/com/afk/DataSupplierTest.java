package com.afk;

import com.afk.testdata.TestData;
import com.afk.utils.DataProviderUtils;
import org.testng.annotations.Test;

/**
 * DataSupplierTest class demonstrates the usage of data-driven testing in TestNG.
 * This class utilizes the DataProvider feature to supply test data from an external source
 * and executes the test method for each set of data.
 */
public class DataSupplierTest {

    /**
     * Test method that receives data from the DataProvider.
     * The method prints the username, password, and expected title from the TestData object.
     *
     * @param testData The TestData object containing the data for the test case.
     */
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void dataSupplierTest(TestData testData) {
        System.out.println("Username: " + testData.getUsername());
        System.out.println("Password: " + testData.getPassword());
        System.out.println("Expected Title: " + testData.getExpectedTitle());
    }
}
