package space.squid.services.sign;

public interface SignService {

    /**
     * @param filename    String filename the asset will have on S3, if null random name will be used.
     * @param contentType String type of file being uploaded. This is needed for the Policy generation
     * @return String/JSON representing a signed object
     */
    String signRequest(String filename, String contentType);
}
