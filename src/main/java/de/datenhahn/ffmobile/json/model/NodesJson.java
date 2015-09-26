package de.datenhahn.ffmobile.json.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NodesJson {
    Date timestamp;
    String version;
    Map<String, FreifunkNode> nodes;

    public List<FreifunkNode> getRouters() {
        ArrayList<FreifunkNode> routers = new ArrayList<>();
        for(FreifunkNode node : nodes.values()) {
            if(!node.getFlags().isGateway()) {
                routers.add(node);
            }
        }
        return routers;
    }

    public List<FreifunkNode> getOnlineRouters() {
        ArrayList<FreifunkNode> routers = new ArrayList<>();
        for(FreifunkNode node : nodes.values()) {
            if(!node.getFlags().isGateway() && node.getFlags().isOnline()) {
                routers.add(node);
            }
        }
        return routers;
    }

    public List<FreifunkNode> getGateways() {
        ArrayList<FreifunkNode> gateways = new ArrayList<>();
        for(FreifunkNode node : nodes.values()) {
            if(node.getFlags().isGateway()) {
                gateways.add(node);
            }
        }
        return gateways;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, FreifunkNode> getNodes() {
        return nodes;
    }

    public void setNodes(Map<String, FreifunkNode> nodes) {
        this.nodes = nodes;
    }
}
