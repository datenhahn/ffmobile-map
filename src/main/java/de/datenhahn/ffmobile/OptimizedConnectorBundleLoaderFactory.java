package de.datenhahn.ffmobile;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;
import com.vaadin.shared.ui.Connect.LoadStyle;

import java.util.HashSet;
import java.util.Set;

public class OptimizedConnectorBundleLoaderFactory extends ConnectorBundleLoaderFactory {
    private Set<String> eagerConnectors = new HashSet<String>();
    {
            eagerConnectors.add(com.vaadin.client.ui.ui.UIConnector.class.getName());
            eagerConnectors.add(org.vaadin.addon.leaflet.client.LeafletCircleConnector.class.getName());
            eagerConnectors.add(org.vaadin.addon.leaflet.client.LeafletLayersConnector.class.getName());
            eagerConnectors.add(com.vaadin.client.ui.csslayout.CssLayoutConnector.class.getName());
            eagerConnectors.add(org.vaadin.addon.leaflet.client.LeafletMapConnector.class.getName());
            eagerConnectors.add(com.vaadin.addon.touchkit.gwt.client.vcom.GeolocatorConnector.class.getName());
            eagerConnectors.add(com.vaadin.client.ui.label.LabelConnector.class.getName());
            eagerConnectors.add(org.vaadin.addon.leaflet.client.LeafletTileLayerConnector.class.getName());
            eagerConnectors.add(com.vaadin.client.ui.button.ButtonConnector.class.getName());
            eagerConnectors.add(org.vaadin.addon.leaflet.client.LeafletLayerGroupConnector.class.getName());
    }

    @Override
    protected LoadStyle getLoadStyle(JClassType connectorType) {
            if (eagerConnectors.contains(connectorType.getQualifiedBinaryName())) {
                    return LoadStyle.EAGER;
            } else {
                    // Loads all other connectors immediately after the initial view has
                    // been rendered
                    return LoadStyle.DEFERRED;
            }
    }
}
