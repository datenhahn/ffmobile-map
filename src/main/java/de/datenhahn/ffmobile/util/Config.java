package de.datenhahn.ffmobile.util;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Value;

@SpringComponent
public class Config {

    @Value("${ffmobile.jsonUrl:}")
    private String nodesJsonUrl;

    @Value("${ffmobile.jsonPath:}")
    private String nodesJsonPath;

    public String getNodesJsonUrl() {
        return nodesJsonUrl;
    }

    public void setNodesJsonUrl(String nodesJsonUrl) {
        this.nodesJsonUrl = nodesJsonUrl;
    }

    public String getNodesJsonPath() {
        return nodesJsonPath;
    }

    public void setNodesJsonPath(String nodesJsonPath) {
        this.nodesJsonPath = nodesJsonPath;
    }
}
