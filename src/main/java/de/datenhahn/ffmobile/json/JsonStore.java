package de.datenhahn.ffmobile.json;

import com.vaadin.spring.annotation.SpringComponent;
import de.datenhahn.ffmobile.json.model.NodesJson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent
public class JsonStore {

    @Autowired
    JsonService jsonService;

    private NodesJson nodesJson;

    @PostConstruct
    public void init() {
        nodesJson =jsonService.retrieveNodesJson();
    }

    public NodesJson getNodesJson() {
        return nodesJson;
    }

    public void setNodesJson(NodesJson nodesJson) {
        this.nodesJson = nodesJson;
    }
}
