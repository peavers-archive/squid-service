package space.squid.configuration;

/**
 * Configuration properties for Amazon
 */
public class AmazonConfiguration {

    private String access;

    private String secret;

    private String region;

    private String bucket;

    public String getRegion() {
        return region;
    }

    public String getSecret() {
        return secret;
    }

    public String getAccess() {
        return access;
    }

    public String getBucket() {
        return bucket;
    }
}
