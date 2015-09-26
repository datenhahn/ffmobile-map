package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class FirmwareInfo {
    @JsonProperty("base")
    String gluonBase;
    String release;

    public String getGluonBase() {
        return gluonBase;
    }

    public void setGluonBase(String gluonBase) {
        this.gluonBase = gluonBase;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}
