package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class System {

    @JsonProperty("site_code")
    String siteCode;
    String role;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
