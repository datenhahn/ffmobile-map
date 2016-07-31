package de.datenhahn.ffmobile.util;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Value;

@SpringComponent
public class Config {

    @Value("${ffmobile.jsonUrlUnsafeSsl:}")
    private String jsonUrlUnsafeSsl;

    @Value("${ffmobile.jsonUrl:}")
    private String nodesJsonUrl;

    @Value("${ffmobile.jsonPath:}")
    private String nodesJsonPath;

    @Value("${ffmobile.brandingText:}")
    private String brandingText;

    @Value("${ffmobile.brandingLogoUrl:}")
    private String brandingLogoUrl;

    @Value("${ffmobile.tileUrlPattern:}")
    private String tileUrlPattern;

    @Value("${ffmobile.tileUrlSubDomains:}")
    private String tileUrlSubDomains;

    public String getNodesJsonUrl() {
        return nodesJsonUrl;
    }

    public void setNodesJsonUrl(String nodesJsonUrl) {
        this.nodesJsonUrl = nodesJsonUrl;
    }

    public String getNodesJsonPath() {
        return nodesJsonPath;
    }

    public void setNodesJsonPath(String nodesJsonPath) {
        this.nodesJsonPath = nodesJsonPath;
    }

    public String getBrandingText() {
        return brandingText;
    }

    public void setBrandingText(String brandingText) {
        this.brandingText = brandingText;
    }

    public String getBrandingLogoUrl() {
        return brandingLogoUrl;
    }

    public void setBrandingLogoUrl(String brandingLogoUrl) {
        this.brandingLogoUrl = brandingLogoUrl;
    }

    public String getTileUrlSubDomains() {
        return tileUrlSubDomains;
    }

    public void setTileUrlSubDomains(String tileUrlSubDomains) {
        this.tileUrlSubDomains = tileUrlSubDomains;
    }

    public String getTileUrlPattern() {
        return tileUrlPattern;
    }

    public void setTileUrlPattern(String tileUrlPattern) {
        this.tileUrlPattern = tileUrlPattern;
    }

    public String getJsonUrlUnsafeSsl() {
        return jsonUrlUnsafeSsl;
    }

    public void setJsonUrlUnsafeSsl(String jsonUrlUnsafeSsl) {
        this.jsonUrlUnsafeSsl = jsonUrlUnsafeSsl;
    }
}
