package com.afk.config;

import org.aeonbits.owner.Config;

/**
 * The FrameworkConfig interface defines the configuration properties for the automation framework.
 * It uses the OWNER library to map configuration properties to methods, allowing easy access
 * to these properties throughout the framework. The properties are loaded from a file specified
 * by the @Config.Sources annotation.
 */
@Config.Sources("classpath:config.properties")
public interface FrameworkConfig extends Config {

    /**
     * Gets the timeout duration for page loads and element waits.
     *
     * @return the timeout duration in seconds
     */
    @Key("timeout")
    long timeout();

    /**
     * Gets the base URL for the application under test.
     *
     * @return the base URL as a string
     */
    @Key("url")
    String url();

    /**
     * Gets the browser name to be used for the tests.
     *
     * @return the browser name as a string (e.g., "chrome", "firefox")
     */
    @Key("browser")
    String browser();

    /**
     * Gets the run mode for the tests (e.g., local or remote).
     *
     * @return the run mode as a string
     */
    @Key("runmode")
    String runmode();

    /**
     * Gets the remote WebDriver URL for executing tests on a remote server.
     *
     * @return the remote WebDriver URL as a string
     */
    @Key("remoteurl")
    String remoteurl();
}
