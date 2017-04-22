package space.squid.modules;

import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import space.squid.configuration.SquidConfiguration;
import space.squid.filters.CORSResponseFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Adds generic filter settings used in each Dropwizard project. Provides exposure to Dropwizard specific
 * context
 * <p>
 * Modules can either extend this, or AbstractModule.
 */
public class BaseModule extends DropwizardAwareModule<SquidConfiguration> {

    private Environment environment;

    @Override
    protected void configure() {
        environment = environment();

        environment.jersey().register(CORSResponseFilter.class);
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
            false,
            environment.getApplicationContext().getContextPath() + "*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,PATCH,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
    }
}
