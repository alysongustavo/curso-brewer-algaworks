package br.com.alyson.brewer.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {

    private Properties properties;

    public PropertiesRead(String propertyFileName) throws IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }
}
