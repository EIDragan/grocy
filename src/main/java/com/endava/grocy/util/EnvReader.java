package com.endava.grocy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvReader {

    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env");
        InputStream resourceAsStream = EnvReader.class.getClassLoader().getResourceAsStream("env/" + env + ".properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException("Can't read property file", e);
        }
    }

    public static String getBaseUri() {
        return properties.getProperty("base.uri");
    }
    public static Integer getPort() {
        return Integer.parseInt(properties.getProperty("port"));
    }

    public static String getBasePath() {
        return properties.getProperty("base.path");
    }

    public static String getApiKey() {
        return properties.getProperty("api.key");
    }
}
