package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {

    private long clients;
    private String gateway;
    private double loadavg;
    @JsonProperty("memory_usage")
    private double memoryUsage;

    Traffic traffic;

    @JsonProperty("rootfs_usage")
    private double rootfsUsage;
    private double uptime;

    public Traffic getTraffic() {
        return traffic;
    }

    public void setTraffic(Traffic traffic) {
        this.traffic = traffic;
    }

    public long getClients() {
        return clients;
    }

    public void setClients(long clients) {
        this.clients = clients;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public double getLoadavg() {
        return loadavg;
    }

    public void setLoadavg(double loadavg) {
        this.loadavg = loadavg;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public double getRootfsUsage() {
        return rootfsUsage;
    }

    public void setRootfsUsage(double rootfsUsage) {
        this.rootfsUsage = rootfsUsage;
    }

    public double getUptime() {
        return uptime;
    }

    public void setUptime(double uptime) {
        this.uptime = uptime;
    }
}
