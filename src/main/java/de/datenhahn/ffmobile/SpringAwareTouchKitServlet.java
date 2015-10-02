package de.datenhahn.ffmobile;

import com.vaadin.addon.touchkit.settings.TouchKitSettings;
import com.vaadin.spring.server.SpringVaadinServlet;
import de.datenhahn.ffmobile.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * License: http://www.wtfpl.net
 *
 * @author Matti Tahvonen
 */
public class SpringAwareTouchKitServlet extends SpringVaadinServlet {

    TouchKitSettings touchKitSettings;

    @Autowired
    Config config;

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                getServletConfig().getServletContext());

        touchKitSettings = new TouchKitSettings(getService());
        touchKitSettings.getWebAppSettings().setWebAppCapable(true);
        String contextPath = getServletConfig().getServletContext()
                .getContextPath();

        if(!StringUtils.isEmpty(config.getBrandingLogoUrl())) {
            touchKitSettings.getApplicationIcons().addApplicationIcon(
                    contextPath + config.getBrandingLogoUrl());
            touchKitSettings.getWebAppSettings().setStartupImage(
                    contextPath + config.getBrandingLogoUrl());
        }
        touchKitSettings.getApplicationCacheSettings().setCacheManifestEnabled(true);
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