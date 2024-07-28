package com.afk.testdata;

import com.creditdatamw.zerocell.annotation.Column;

/**
 * TestData is a POJO class that represents test data used in the test cases.
 * The class utilizes annotations from the ZeroCell library to map Excel columns to fields.
 */
public class TestData {

    @Column(name = "testcasename", index=0)
    private String testcasename;

    @Column(name = "username", index=1)
    private String username;

    @Column(name = "password", index=2)
    private String password;

    @Column(name = "expectedTitle", index=3)
    private String expectedTitle;

    // Getters

    /**
     * Gets the name of the test case.
     *
     * @return The test case name.
     */
    public String getTestcasename() {
        return testcasename;
    }

    /**
     * Gets the username for the test case.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password for the test case.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the expected title for validation after login.
     *
     * @return The expected title.
     */
    public String getExpectedTitle() {
        return expectedTitle;
    }
}
