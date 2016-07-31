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

The default osm tile server should be only used for demo purposes. For production use I recommend setting up a
caching reverseproxy for the tiles to take load from the official osm server. You can pass the tile url pattern
like this.

  java -jar ffmobile-map-0.0.1-SNAPSHOT.jar --ffmobile.jsonUrl=YOUR_JSON_URL -Dffmobile.tileUrlPattern="http://{s}.YOUR_TILE_SERVER/tiles/osmde/{z}/{x}/{y}.png" -Dffmobile.tileUrlSubDomains="a,b,c,d"


## Server setup

In the `examples`-directory repository you find a simple bash script to start the application in background and some
nginx-config to proxy the requests. The application starts always listening on all interfaces on port 8080 for now.
I recommend blocking port 8080 from outside by iptables and setup the nginx-proxy on port 80 or 443 to serve the map.

## Commandline Options

The following startup options are available:

* ffmobile.jsonUrlUnsafeSsl : when this option is passed with any value (e.g. -Dffmobile.jsonUrlUnsafeSsl="true") the url reader will not check the certificate chain (good for incomplete ssl setups of the nods.json server). 
* ffmobile.jsonUrl : the url to the nodes.json for download
* ffmobile.jsonPath : you can also supply the json from the local file system (only use jsonUrl OR jsonPath, not both at once)
* ffmobile.brandingText : a branding text which is shown in the upper right corner of the website
* ffmobile.brandingLogoUrl : url to a branding logo which is shown in the upper right corner of the website
* ffmobile.tileUrlPattern : Open Street Maps tileserver url pattern for leaflet (e.g. "http://{s}.YOUR_TILE_SERVER/tiles/osmde/{z}/{x}/{y}.png")
* ffmobile.tileUrlSubDomains : leaflet url subdomains (e.g. "a,b,c,d")

## License

The code for this map itself is licensed under the MIT-License ( http://opensource.org/licenses/MIT )
Other licenses may apply regarding the dependencies (see vaadin, leaflet, etc.).