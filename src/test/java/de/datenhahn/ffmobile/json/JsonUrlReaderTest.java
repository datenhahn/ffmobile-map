package de.datenhahn.ffmobile.json;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class JsonUrlReaderTest {

    private static final String JSON_TEST_URL = "https://raw.githubusercontent.com/datenhahn/ffmobile-map/master/src/test/resources/de/datenhahn/ffmobile/json/nodes.json";

    @Test
    public void testReadUrl() throws Exception {

        JsonUrlReader urlReader = new JsonUrlReader();
        InputStream inputStream = urlReader.readUrl(JSON_TEST_URL);
        String theString = IOUtils.toString(inputStream);
        assertThat(theString.length(), greaterThan(10000));
    }


}