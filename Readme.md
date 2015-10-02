# Freifunk München Mobile Map

A minimal mobile map for the munich freifunk community nodes, based on spring-boot, vaadin and leaflet.

## Online Version

http://map.datenhahn.de

## Build it

Clone the repository and execute
  rm -rf target && mvn clean vaadin:clean vaadin:compile-theme install -P compile-widgetsets
  
I separated the widgetset compile from the rest of the build job, so the last mvn install is to repackage the files.
  
## Run it

  cd target/
  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonUrl=https://raw.githubusercontent.com/datenhahn/ffmobile-map/master/src/test/resources/de/datenhahn/ffmobile/json/nodes.json --ffmobile.brandingText="Freifunk München Mobile Map" --ffmobile.brandingLogoUrl="./VAADIN/themes/ffmobile/images/ffmuc-logo.png
  
Or run from a local json file

  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonPath=/tmp/nodes.json
  
The map will automatically update itself every 15 minutes.

## Server setup

In the `examples`-directory repository you find a simple bash script to start the application in background and some
nginx-config to proxy the requests. The application starts always listening on all interfaces on port 8080 for now.
I recommend blocking port 8080 from outside by iptables and setup the nginx-proxy on port 80 or 443 to serve the map.

## Workarounds

* Currently the map does not check SSL certificate chain for json download urls, will be removed as soon as ffmuc certificate chain
is fixed.
* The jackson json parser library is configured to non strict parsing, as currently the nodes.json contains some wrong entries created by the alfred service (function: 0x.... entries)

## License

The code for this map itself is licensed under the MIT-License ( http://opensource.org/licenses/MIT )
Other licenses may apply regarding the dependencies (see vaadin, leaflet, etc.).