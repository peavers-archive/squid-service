package space.squid.services.sign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jets3t.service.Constants;
import org.jets3t.service.S3Service;
import org.jets3t.service.utils.ServiceUtils;
import space.squid.configuration.AmazonConfiguration;
import space.squid.domain.model.SignRequest;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class SignServiceImpl implements SignService {

    private String awsBucket;
    private String awsAccessKey;
    private String awsSecretKey;

    SignServiceImpl(final AmazonConfiguration amazon) {
        awsSecretKey = amazon.getSecret();
        awsAccessKey = amazon.getAccess();
        awsBucket = amazon.getBucket();
    }

    @Override
    public String signRequest(final String contentType) {
        final String randomFileName = createRandomName();

        String policy = createPolicy(randomFileName, contentType);

        SignRequest signRequest = new SignRequest();
        signRequest.setAwsAccessKeyId(awsAccessKey);
        signRequest.setPolicy(policy);
        signRequest.setSignature(ServiceUtils.signWithHmacSha1(awsSecretKey, policy));
        signRequest.setBucket(awsBucket);
        signRequest.setKey(randomFileName);
        signRequest.setAcl("public-read");
        signRequest.setContentType(contentType);
        signRequest.setExpires(createExpireTime().toString());
        signRequest.setSuccessActionStatus("201");

        return createJsonString(signRequest);
    }

    /**
     * Grunt work of creating a policy document
     *
     * @param randomFileName String name of the file being uploaded
     * @param contentType    String type of file e.g image/jpg
     * @return String
     */
    private String createPolicy(final String randomFileName, final String contentType) {
        try {
            String[] conditions = {
                S3Service.generatePostPolicyCondition_Equality("bucket", awsBucket),
                S3Service.generatePostPolicyCondition_Equality("key", randomFileName),
                S3Service.generatePostPolicyCondition_Equality("acl", "public-read"),
                S3Service.generatePostPolicyCondition_Equality("expires", createExpireTime().toString()),
                S3Service.generatePostPolicyCondition_Equality("content-Type", contentType),
                S3Service.generatePostPolicyCondition_Equality("success_action_status", "201"),
                S3Service.generatePostPolicyCondition_AllowAnyValue("cache-control")
            };

            String policyDocument = "{\"expiration\": \"" + ServiceUtils.formatIso8601Date(createExpireTime()) + "\", \"conditions\": [" + ServiceUtils.join(conditions, ",") + "]}";

            return ServiceUtils.toBase64(policyDocument.getBytes(Constants.DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Since we don't want versioned files, give each file a unique name when uploaded
     *
     * @return String
     */
    private String createRandomName() {
        return UUID.randomUUID().toString();
    }

    /**
     * Create expire date for policy document
     *
     * @return Date
     */
    private Date createExpireTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);

        return cal.getTime();
    }

    /**
     * Converts object into JSON String for frontend consumption
     *
     * @param request SignRequest object
     * @return String
     */
    private String createJsonString(final SignRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
