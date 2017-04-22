package space.squid.services.sign;


import com.google.inject.Inject;
import com.google.inject.Provider;
import space.squid.configuration.SquidConfiguration;

public class SignServiceProvider implements Provider<SignService> {

    @Inject
    private SquidConfiguration configuration;

    @Override
    public SignService get() {
        return new SignServiceImpl(configuration.getAmazon());
    }
}
