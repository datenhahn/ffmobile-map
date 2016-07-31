package de.datenhahn.ffmobile.json;

import com.vaadin.spring.annotation.SpringComponent;
import de.datenhahn.ffmobile.util.Config;
import de.datenhahn.ffmobile.util.SSLUtilities;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

@SpringComponent
public class JsonUrlReader {

    private final static Logger LOGGER = Logger.getLogger(JsonUrlReader.class.getName());

    @Autowired
    private Config config;

    @PostConstruct
    public void init() {
        if(StringUtils.isNotEmpty(config.getJsonUrlUnsafeSsl())) {
            SSLUtilities.trustAllHostnames();
            SSLUtilities.trustAllHttpsCertificates();
        }
    }

    public InputStream readUrl(String url) throws IOException {
        URL link = new URL(url);
        HttpURLConnection sourceConnection = (HttpURLConnection) link.openConnection();

        sourceConnection.setFollowRedirects(true);
        sourceConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        sourceConnection.connect();
        String encoding = sourceConnection.getContentEncoding();
        InputStream resultingInputStream = null;


        if (encoding != null && encoding.equalsIgnoreCase("gzip")) {

            resultingInputStream = new GZIPInputStream(sourceConnection.getInputStream());

        } else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {

            resultingInputStream = new InflaterInputStream(sourceConnection.getInputStream(), new Inflater(true));

        } else {

            resultingInputStream = sourceConnection.getInputStream();

        }

        return resultingInputStream;
    }
}
