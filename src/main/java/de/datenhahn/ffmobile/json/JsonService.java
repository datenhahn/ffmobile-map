package de.datenhahn.ffmobile.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.spring.annotation.SpringComponent;
import de.datenhahn.ffmobile.json.model.NodesJson;
import de.datenhahn.ffmobile.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@SpringComponent
public class JsonService {

    @Autowired
    private Config config;

    @Autowired
    private JsonUrlReader urlReader;

    @Autowired
    private JsonFileReader fileReader;

    private ObjectMapper mapper;

    private final static Logger LOGGER = Logger.getLogger(JsonService.class.getName());


    public JsonService() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private InputStream getNodesJsonInputStream() {
        if (!StringUtils.isEmpty(config.getNodesJsonPath())) {
            return getNodesJsonFromFile();
        } else if (!StringUtils.isEmpty(config.getNodesJsonUrl())) {
            return getNodesJsonFromUrl();
        }

        throw new IllegalStateException("ffmobile.jsonPath or ffmobile.jsonUrl not set, please add commandline option: --ffmobile.jsonUrl=\"http://example.com/nodes.json\"");
    }

    public NodesJson retrieveNodesJson() {
        try {
            return mapper.readValue(getNodesJsonInputStream(), NodesJson.class);
        } catch (IOException e) {
            String msg = "Could not parse nodes json: " + e.getMessage();
            LOGGER.severe(msg);
            throw new RuntimeException(msg);
        }
    }

    private InputStream getNodesJsonFromUrl() {
        try {
            return urlReader.readUrl(config.getNodesJsonUrl());
        } catch (Exception e) {
            LOGGER.severe("Could not download json: " + e.getMessage());
        }
        return null;
    }

    private InputStream getNodesJsonFromFile() {
        try {
            return fileReader.readFile(config.getNodesJsonPath());
        } catch (IOException e) {
            LOGGER.severe("Could not read json from filesystem: " + e.getMessage());
        }
        return null;
    }

}
