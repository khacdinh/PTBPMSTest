package com.btbms.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PTBProperties extends Properties {
    private static PTBProperties oscarProperties = new PTBProperties();

    public static PTBProperties getInstance() {
        return oscarProperties;
    }

    private PTBProperties() {
        try {
            readFromFile("/application.properties");
            String overrideProperties = System.getProperty("oscar_override_properties");
            if (overrideProperties != null) {
                readFromFile(overrideProperties);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String url) throws IOException {
        InputStream is = getClass().getResourceAsStream(url);
        if (is == null) is = new FileInputStream(url);

        try {
            load(is);
        } finally {
            is.close();
        }
    }
}
