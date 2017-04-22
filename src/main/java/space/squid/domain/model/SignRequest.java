package space.squid.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO in the format ember-uploader is expecting back.
 */
public class SignRequest {

    @JsonProperty("acl")
    private String acl;

    @JsonProperty("awsaccesskeyid")
    private String awsAccessKeyId;

    @JsonProperty("bucket")
    private String bucket;

    @JsonProperty("cache-control")
    private String cacheControl;

    @JsonProperty("content-Type")
    private String contentType;

    @JsonProperty("expires")
    private String expires;

    @JsonProperty("key")
    private String key;

    @JsonProperty("policy")
    private String policy;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("success_action_status")
    private String successActionStatus;

    public SignRequest() {

    }

    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl;
    }

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSuccessActionStatus() {
        return successActionStatus;
    }

    public void setSuccessActionStatus(String successActionStatus) {
        this.successActionStatus = successActionStatus;
    }
}
