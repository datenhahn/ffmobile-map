package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Software {
    @JsonProperty("autoupdater")
    AutoupdaterInfo autoupdaterInfo;

    @JsonProperty("firmware")
    FirmwareInfo firmwareInfo;

    @JsonProperty("batman-adv")
    BatmanAdvInfo batmanAdvInfo;

    @JsonProperty("fastd")
    FastdInfo fastdInfo;

    @JsonProperty("status-page")
    StatusPage statusPage;

    public AutoupdaterInfo getAutoupdaterInfo() {
        return autoupdaterInfo;
    }

    public void setAutoupdaterInfo(AutoupdaterInfo autoupdaterInfo) {
        this.autoupdaterInfo = autoupdaterInfo;
    }

    public FirmwareInfo getFirmwareInfo() {
        return firmwareInfo;
    }

    public void setFirmwareInfo(FirmwareInfo firmwareInfo) {
        this.firmwareInfo = firmwareInfo;
    }

    public BatmanAdvInfo getBatmanAdvInfo() {
        return batmanAdvInfo;
    }

    public void setBatmanAdvInfo(BatmanAdvInfo batmanAdvInfo) {
        this.batmanAdvInfo = batmanAdvInfo;
    }

    public FastdInfo getFastdInfo() {
        return fastdInfo;
    }

    public void setFastdInfo(FastdInfo fastdInfo) {
        this.fastdInfo = fastdInfo;
    }

    public StatusPage getStatusPage() {
        return statusPage;
    }

    public void setStatusPage(StatusPage statusPage) {
        this.statusPage = statusPage;
    }
}
