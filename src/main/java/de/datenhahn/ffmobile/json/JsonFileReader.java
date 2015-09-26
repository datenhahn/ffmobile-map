package de.datenhahn.ffmobile.json;

import com.vaadin.spring.annotation.SpringComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringComponent
public class JsonFileReader {

    public InputStream readFile(String path) throws IOException {
        return new FileInputStream(path);
    }
}
