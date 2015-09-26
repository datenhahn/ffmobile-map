package de.datenhahn.ffmobile.json.model;

public class Flags {
    private boolean gateway;
    private boolean online;

    public boolean isGateway() {
        return gateway;
    }

    public void setGateway(boolean gateway) {
        this.gateway = gateway;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
