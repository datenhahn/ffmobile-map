package de.datenhahn.ffmobile.json.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NodesJson {
    Date timestamp;
    String version;

    private static final Logger logger = LoggerFactory.getLogger(NodesJson.class);
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

    private boolean hasWirelessMesh(FreifunkNode node) {
        if(node.getNodeInfo().getNetwork() != null) {
            if(node.getNodeInfo().getNetwork().getMesh() != null) {
                if(node.getNodeInfo().getNetwork().getMesh().get("bat0") != null) {
                    if(node.getNodeInfo().getNetwork().getMesh().get("bat0").getInterfaces() != null) {
                        if( node.getNodeInfo().getNetwork().getMesh().get("bat0").getInterfaces().getWireless() != null) {
                            return true;
                        }
                    }
                }
            }
        }
        logger.info("Dropping Non Wireless router: " + node.getNodeInfo().getHostname());
        return false;
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
