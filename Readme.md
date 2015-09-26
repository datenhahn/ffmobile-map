.h1 Freifunk München Mobile Map

A minimal mobile map for the munich freifunk community nodes, based on spring-boot, vaadin and leaflet.

.h2 Online Version

http://map.datenhahn.de

.h2 Build it

Clone the repository and execute
  mvn clean install -P compile-widgetsets
  
.h2 Run it

  cd target/
  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonUrl=http://..../nodes.json
  
Or run from a local json file

  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonPath=/tmp/nodes.json
  
The map will automatically update itself every 15 minutes.

.h2 Workarounds

* Currently the map does not check SSL certificate chain for json download urls, will be removed as soon as ffmuc certificate chain
is fixed.
* The jackson json parser library is configured to non strict parsing, as currently the nodes.json contains some wrong entries created by the alfred service (function: 0x.... entries)

.h2 License

The code for this map itself is licensed under the MIT-License ( http://opensource.org/licenses/MIT )
Other licenses may apply regarding the dependencies (see vaadin, leaflet, etc.).