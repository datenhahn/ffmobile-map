package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class Traffic {
    private TrafficStatistics forward;

    @JsonProperty("mgmt_rx")
    private TrafficStatistics mgmtRx;

    @JsonProperty("mgmt_tx")
    private TrafficStatistics mgmtTx;
    private TrafficStatistics rx;
    private TrafficStatistics tx;

    public TrafficStatistics getForward() {
        return forward;
    }

    public void setForward(TrafficStatistics forward) {
        this.forward = forward;
    }

    public TrafficStatistics getMgmtRx() {
        return mgmtRx;
    }

    public void setMgmtRx(TrafficStatistics mgmtRx) {
        this.mgmtRx = mgmtRx;
    }

    public TrafficStatistics getMgmtTx() {
        return mgmtTx;
    }

    public void setMgmtTx(TrafficStatistics mgmtTx) {
        this.mgmtTx = mgmtTx;
    }

    public TrafficStatistics getRx() {
        return rx;
    }

    public void setRx(TrafficStatistics rx) {
        this.rx = rx;
    }

    public TrafficStatistics getTx() {
        return tx;
    }

    public void setTx(TrafficStatistics tx) {
        this.tx = tx;
    }
}
