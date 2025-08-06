package com.fxhive.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties from config files.
 * Supports environment-based URL management.
 */
public final class ConfigUtil {

    private static final String CONFIG_FILE = "src/test/resources/config/application.properties";
    private static Properties properties;

    static {
        loadProperties();
    }

    private ConfigUtil() {}

    private static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + CONFIG_FILE, e);
        }
    }

    /**
     * Gets property value by key
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Gets property with default value if not found
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Gets base URL for specified environment
     */
    public static String getBaseUrl(String environment) {
        return getProperty("base.url." + environment.toLowerCase());
    }

    /**
     * Gets default environment base URL
     */
    public static String getDefaultBaseUrl() {
        String defaultEnv = getProperty("default.environment", "dev");
        return getBaseUrl(defaultEnv);
    }

    /**
     * Gets browser name
     */
    public static String getBrowser() {
        return getProperty("default.browser", "chrome");
    }

    /**
     * Gets timeout value
     */
    public static int getTimeout() {
        return Integer.parseInt(getProperty("default.timeout", "10"));
    }
}
