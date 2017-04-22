package space.squid.domain.repository;

import space.squid.services.sign.SignService;

import javax.inject.Inject;

/**
 * Repository preforms the signing action
 */
public class SignRepository {

    @Inject
    private SignService signService;

    /**
     * Constructor
     */
    public SignRepository() {
    }

    /**
     * @param contentType String
     * @return String
     */
    public String signRequest(final String contentType) {
        return signService.signRequest(contentType);
    }
}
