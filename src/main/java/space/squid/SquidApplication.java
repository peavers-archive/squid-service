package space.squid;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import space.squid.configuration.SquidConfiguration;
import space.squid.modules.BaseModule;
import space.squid.services.sign.SignServiceModule;

/**
 * Entry class into the squid service
 */
public class SquidApplication extends Application<SquidConfiguration> {

    private GuiceBundle guiceBundle;

    /**
     * Standard dropwizard entry point
     *
     * @param args server and location of configuration file
     * @throws Exception if invalid arguments
     */
    public static void main(final String[] args) throws Exception {
        new SquidApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<SquidConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.builder()
            .enableAutoConfig(getClass().getPackage().getName())
            .useWebInstallers()
            .modules(
                new BaseModule(),
                new SignServiceModule()
            )
            .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final SquidConfiguration configuration, final Environment environment) throws Exception {

    }
}
