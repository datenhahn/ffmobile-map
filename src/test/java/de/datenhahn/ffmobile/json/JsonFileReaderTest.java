package de.datenhahn.ffmobile.json;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class JsonFileReaderTest {

    @Test
    public void testReadFile() throws Exception {

        JsonFileReader fileReader = new JsonFileReader();
        String path = getClass().getClassLoader().getResource("de/datenhahn/ffmobile/json/nodes.json").getPath();
        InputStream inputStream = fileReader.readFile(path);
        String theString = IOUtils.toString(inputStream);
        assertThat(theString.length(), greaterThan(1300000));
    }
}