package space.squid.services.sign;

import com.google.inject.AbstractModule;

public class SignServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SignService.class).toProvider(SignServiceProvider.class).asEagerSingleton();
    }
}
