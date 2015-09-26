package de.datenhahn.ffmobile.json.model;

class BatmanAdvInfo {
    String compat;
    String version;
    String gwmode;

    public String getGwmode() {
        return gwmode;
    }

    public void setGwmode(String gwmode) {
        this.gwmode = gwmode;
    }

    public String getCompat() {
        return compat;
    }

    public void setCompat(String compat) {
        this.compat = compat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
