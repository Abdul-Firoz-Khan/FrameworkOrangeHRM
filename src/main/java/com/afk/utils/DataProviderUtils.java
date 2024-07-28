package com.afk.utils;

import com.afk.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

/**
 * DataProviderUtils is a utility class that provides test data for test cases.
 * It uses the DataSupplier annotation from the SSKorol library to supply test data
 * in parallel from an Excel file.
 */
public class DataProviderUtils {

    /**
     * Supplies test data in parallel from the "testdata.xlsx" file.
     * The data is read into a stream of TestData objects.
     *
     * @return A StreamEx object containing the test data.
     */
    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getData() {
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }
}
