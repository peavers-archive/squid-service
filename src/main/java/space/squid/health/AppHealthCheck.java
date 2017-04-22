package space.squid.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Dropwizard health check
 */
public class AppHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
