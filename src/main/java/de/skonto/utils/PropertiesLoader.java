/*
 * created by max$
 */


package de.skonto.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static final String PROP_FILE="/test.properties";

    public PropertiesLoader() {
    }
    public static String loadProperty(String name){
        Properties properties= new Properties();
        try {
            properties.load(PropertiesLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value= "";
        if (name != null){
            value = properties.getProperty(name);
        }
        return value;
    }
}