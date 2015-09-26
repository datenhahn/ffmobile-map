package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.datenhahn.ffmobile.util.DateUtil;

import java.util.Date;

public class FreifunkNode {

    @JsonProperty("firstseen")
    Date firstSeen;

    @JsonProperty("lastseen")
    Date lastSeen;

    Flags flags;

    @JsonProperty("nodeinfo")
    NodeInfo nodeInfo;
    Statistics statistics;

    public Date getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public NodeInfo getNodeInfo() {
        return nodeInfo;
    }

    public void setNodeInfo(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Long getLastSeenDays() {
        return DateUtil.getDifferenceDays(lastSeen, new Date());
    }

    public Long getFirstSeenDays() {
        return DateUtil.getDifferenceDays(firstSeen, new Date());
    }

}
