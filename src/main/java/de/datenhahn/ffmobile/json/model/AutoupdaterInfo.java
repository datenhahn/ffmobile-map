package de.datenhahn.ffmobile.json.model;

class AutoupdaterInfo {
    String branch;
    boolean enabled;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
