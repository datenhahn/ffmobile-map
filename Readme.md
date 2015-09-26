# Freifunk München Mobile Map

A minimal mobile map for the munich freifunk community nodes, based on spring-boot, vaadin and leaflet.

## Online Version

http://map.datenhahn.de

## Build it

Clone the repository and execute
  mvn clean install -P compile-widgetsets
  
## Run it

  cd target/
  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonUrl=http://..../nodes.json
  
Or run from a local json file

  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonPath=/tmp/nodes.json
  
The map will automatically update itself every 15 minutes.

## Workarounds

* Currently the map does not check SSL certificate chain for json download urls, will be removed as soon as ffmuc certificate chain
is fixed.
* The jackson json parser library is configured to non strict parsing, as currently the nodes.json contains some wrong entries created by the alfred service (function: 0x.... entries)

## License

The code for this map itself is licensed under the MIT-License ( http://opensource.org/licenses/MIT )
Other licenses may apply regarding the dependencies (see vaadin, leaflet, etc.).