package space.squid.services.sign;

public interface SignService {

    /**
     * @param contentType String type of file being uploaded. This is needed for the Policy generation
     * @return String/JSON representing a signed object
     */
    String signRequest(String contentType);
}
