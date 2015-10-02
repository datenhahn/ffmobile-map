#!/bin/bash
nohup java -jar ffmobile-map-0.0.1-SNAPSHOT.jar \
                  --ffmobile.jsonUrl="https://raw.githubusercontent.com/datenhahn/ffmobile-map/master/src/test/resources/de/datenhahn/ffmobile/json/nodes.json" \
                  --ffmobile.brandingText="Freifunk München Mobile Map" \
                  --ffmobile.brandingLogoUrl="./VAADIN/themes/ffmobile/images/ffmuc-logo.png" \
                  > /tmp/map.log 2>&1  < /dev/null &