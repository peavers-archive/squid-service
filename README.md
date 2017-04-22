# squid-service
Signs upload requests for Amazon S3 buckets. 

### What
A microservice responsible for signing requests of objects being uploaded to Amazon S3. 
Designed to work specifically with ember-uploader https://github.com/benefitcloud/ember-uploader

### How
Send a `GET` request to `http://localhost:8080/api/sign-request`. The endpoint accepts a single parameter of `type` which should be the file type
you're trying to upload. Ember-uploader will include this by default. 

### Configuration
You'll need to set your Amazon access and secret keys in the `config-production.yml` file, along with what bucket you want files going into. For example

```
amazon:
  access: 'xxx'
  secret: 'xxx'
  bucket: 'xxx'
```

### Running
Executing via the built Docker container is the preferred way of using this microservice.

@TODO
