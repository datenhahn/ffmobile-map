package de.datenhahn.ffmobile.json.model;

import java.util.List;

public class Interfaces {

    List<String> tunnel;
    List<String> wireless;
    List<String> other;

    public List<String> getTunnel() {
        return tunnel;
    }

    public void setTunnel(List<String> tunnel) {
        this.tunnel = tunnel;
    }

    public List<String> getWireless() {
        return wireless;
    }

    public void setWireless(List<String> wireless) {
        this.wireless = wireless;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }
}
