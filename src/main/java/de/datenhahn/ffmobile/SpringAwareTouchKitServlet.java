package de.datenhahn.ffmobile;

import com.vaadin.addon.touchkit.settings.TouchKitSettings;
import com.vaadin.server.DefaultDeploymentConfiguration;
import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.spring.server.SpringVaadinServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * License: http://www.wtfpl.net
 *
 * @author Matti Tahvonen
 */
public class SpringAwareTouchKitServlet extends SpringVaadinServlet {

    TouchKitSettings touchKitSettings;
    @Override
    protected DeploymentConfiguration createDeploymentConfiguration(Properties initParameters) {
        initParameters.put("productionMode" , "true");
        return new DefaultDeploymentConfiguration(this.getClass(), initParameters);
    }

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        touchKitSettings = new TouchKitSettings(getService());
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            if (pathInfo.endsWith("themes/touchkit/styles.css")) {
                serveDummyFile(response, "max-age=1000000");
                return;
            } else if (pathInfo.endsWith("PING/")) {
                serveDummyFile(response, "no-store, no-cache, max-age=0, must-revalidate");
                return;
            }
        }
        super.service(request, response);
    }

    private void serveDummyFile(HttpServletResponse response, String cacheControl)
            throws IOException {
        response.setContentType("text/css");
        response.setHeader("Cache-Control", cacheControl);
        response.getOutputStream().write("\n".getBytes());
    }

}