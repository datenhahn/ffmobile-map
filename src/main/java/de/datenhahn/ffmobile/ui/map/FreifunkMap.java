package de.datenhahn.ffmobile.ui.map;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import de.datenhahn.ffmobile.json.model.FreifunkNode;
import de.datenhahn.ffmobile.util.LeafletTuningMap;
import org.vaadin.addon.leaflet.*;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringComponent
@UIScope
public class FreifunkMap {

    public final static int ZOOM_LEVEL_CITY = 13;
    public final static int ZOOM_LEVEL_DETAIL = 18;

    private final static int ROUTER_RADIUS = 25;
    private final static int ME_RADIUS = 13;

    private LMap map;
    private LCircle me;
    private LLayerGroup nodesLayer = new LLayerGroup();

    @PostConstruct
    private void initMap() {
        map = new LeafletTuningMap();
        map.addStyleName("ffmobile-map");
        map.setCustomInitOption("inertia", true);
        map.setCustomInitOption("dragging", true);

        map.setCustomInitOption("touchZoom", true);
        map.setCustomInitOption("tap", false);
        map.addLayer(nodesLayer);

        LTileLayer osmTiles = new LTileLayer("http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
        osmTiles.setSubDomains("a", "b", "c");

        map.addBaseLayer(osmTiles, "OSM");
    }

    public LMap getMap() {
        return map;
    }

    public LCircle createNode(FreifunkNode node) {
        String hostname = node.getNodeInfo().getHostname();
        if (node.getNodeInfo() != null && node.getNodeInfo().getLocation() != null) {
            double lat = node.getNodeInfo().getLocation().getLatitude();
            double lon = node.getNodeInfo().getLocation().getLongitude();
            return createRouter(lat, lon);
        }
        return null;
    }

    public void zoom(double lat, double lon, int zoomLevel) {
        map.setZoomLevel(zoomLevel);
        map.setCenter(lat, lon);
    }

    public void setMe(double lat, double lon) {
        if (me != null) {
            map.removeComponent(me);
        }

        me = createMe(lat, lon);
        map.addComponent(me);
        zoom(lat, lon, ZOOM_LEVEL_DETAIL);
    }

    private LCircle createRouter(double lat, double lon) {
        LCircle router = new LCircle(lat, lon, ROUTER_RADIUS);
        router.setColor("#dc0067");
        router.setFillColor("#dc0067");
        router.setFillOpacity(0.4);
        return router;
    }

    private LCircle createMe(double lat, double lon) {
        LCircle me = new LCircle(lat, lon, ME_RADIUS);
        me.setColor("#009ee0");
        me.setFillColor("#009ee0");
        me.setFillOpacity(0.7);
        me.setId("me");
        return me;
    }

    public void setNodes(List<FreifunkNode> nodes) {

        nodesLayer.removeAllComponents();

        for (FreifunkNode node : nodes) {
            LCircle nodeCircle = createNode(node);
            if (nodeCircle != null) {
                nodesLayer.addComponent(nodeCircle);
            }
        }
    }

}
