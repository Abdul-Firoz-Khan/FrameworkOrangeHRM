package com.afk.config;

/**
 * The ConfigFactory class is a utility class that provides access to the framework's configuration settings.
 * It uses the OWNER library to load configurations from properties files.
 * This class is designed to be used as a singleton, ensuring that the configuration is loaded only once.
 * The configurations are defined in the FrameworkConfig interface.
 */
public final class ConfigFactory {

    // Private constructor to prevent instantiation
    private ConfigFactory() {}

    /**
     * Retrieves the framework's configuration settings.
     * This method uses the OWNER library to create an instance of the FrameworkConfig interface,
     * which contains the configuration settings loaded from the specified properties file.
     *
     * @return an instance of FrameworkConfig containing the configuration settings
     */
    public static FrameworkConfig getConfig() {
        return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
    }
}
