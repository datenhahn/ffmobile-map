package de.datenhahn.ffmobile.json;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@SpringComponent
public class JsonDownloadScheduler {

    @Autowired
    JsonService jsonService;

    @Autowired
    JsonStore jsonStore;

    @Scheduled(fixedRate = 900000)
    public void updateNodesJson() {
        jsonStore.setNodesJson(jsonService.retrieveNodesJson());
    }

}
