package space.squid.configuration;

import io.dropwizard.Configuration;

/**
 * Configuration properties for Squid service
 */
public class SquidConfiguration extends Configuration {

    private AmazonConfiguration amazon = new AmazonConfiguration();

    public AmazonConfiguration getAmazon() {
        return amazon;
    }
}
