package de.datenhahn.ffmobile.ui;

import com.vaadin.addon.touchkit.extensions.Geolocator;
import com.vaadin.addon.touchkit.extensions.PositionCallback;
import com.vaadin.addon.touchkit.gwt.client.vcom.Position;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.BaseTheme;
import de.datenhahn.ffmobile.json.JsonStore;
import de.datenhahn.ffmobile.ui.map.FreifunkMap;
import de.datenhahn.ffmobile.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@Theme("ffmobile")
@SpringUI
@Widgetset("de.datenhahn.ffmobile.FfMobileWidgetset")
public class FfMobileUi extends UI {
    public final static double MUENCHEN_LAT = 48.1455612;
    public final static double MUENCHEN_LON = 11.5767131;

    @Autowired JsonStore jsonStore;

    @Autowired
    Config config;

    @Autowired
    FreifunkMap map;
    Button button;

    class ShowMeOnMap implements PositionCallback {
        @Override
        public void onSuccess(Position position) {
            double latitude = position.getLatitude();
            double longitude = position.getLongitude();

            map.setMe(latitude, longitude);
            button.removeStyleName("location-loading");
        }

        public void onFailure(int errorCode) {
            String message = "Unknown Errorcode " + errorCode;
            switch(errorCode) {
                case 0:
                    message = "ErrorCode 0: unknown error on location";
                    break;
                case 1:
                    message = "ErrorCode 1: permission to location denied";
                    break;
                case 2:
                    message = "ErrorCode 2: the position is unavailable";
                    break;
                case 3:
                    message = "ErrorCode 3: positioning timeout";
                    break;
            }

            Notification.show("Error during locating position: " + message);
            button.removeStyleName("location-loading");
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        CssLayout mapLayout = new CssLayout();
        mapLayout.setSizeFull();

        mapLayout.addComponent(map.getMap());
        map.zoom(MUENCHEN_LAT, MUENCHEN_LON, map.ZOOM_LEVEL_CITY);

        map.setNodes(jsonStore.getNodesJson().getOnlineRouters());

        mapLayout.addComponent(createHeaderOverlay());
        mapLayout.addComponent(createToolbarOverlay());

        setContent(mapLayout);

        Geolocator.detect(new ShowMeOnMap());

    }

    private Component createHeaderOverlay() {
        CssLayout header = new CssLayout();
        Label ffmucText = new Label(config.getBrandingText());
        ffmucText.setSizeUndefined();
        ffmucText.addStyleName("ffmuc-text");
        header.addComponent(ffmucText);
        if(!StringUtils.isEmpty(config.getBrandingLogoUrl())) {
            header.addComponent(new Image(null, new ExternalResource(config.getBrandingLogoUrl())));
        }
        header.addStyleName("ffmobile-header");
        return header;
    }

    private Component createToolbarOverlay() {
        CssLayout overlay = new CssLayout();
        overlay.addStyleName("toolbar-overlay");
        overlay.setWidth("100%");
        button = new Button(" ", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                button.addStyleName("location-loading");
                Geolocator.detect(new ShowMeOnMap());
            }
        });
        button.addStyleName(BaseTheme.BUTTON_LINK);
        button.setIcon(FontAwesome.BULLSEYE);
        button.setSizeUndefined();
        Label label = new Label("© OpenStreetMap contributors<br>NodeInfo loaded: " + jsonStore.getNodesJson().getTimestamp(), ContentMode.HTML);
        label.setSizeUndefined();
        overlay.addComponent(label);
        overlay.addComponent(button);
        return overlay;
    }

}
