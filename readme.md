# squid-service
Signs upload requests for Amazon S3 buckets. 

### What
A Dropwizard microservice responsible for signing requests of objects being uploaded to Amazon S3. 
Designed to work specifically with [ember-uploader](https://github.com/benefitcloud/ember-uploader)

### How
Send a `GET` request to `http://localhost:8080/api/sign-upload`. The endpoint accepts a single parameter of `type` which should be the file type
you're trying to upload. Ember-uploader will include this by default. 

### Configuration
You'll need to set your Amazon access and secret keys in the `config.yml` file, along with what bucket you want files going into. 
This is used if you're running from the Docker container (recommended) or building it as a fat jar. 

### Running
Executing via a Docker container is the preferred way of using this microservice. Run the following command anywhere you have Docker installed:
```
docker create \
    --name=squid-service \
    --restart=always \
    -v <config location>:/config \
    -e PGID=1000 -e PUID=1000 \
    -e TZ=Pacific/Auckland \
    -p 8080:8080 \
    peavers/squid-service
```

Where `<config location>` points to the config file containing your details as above. 

Once the container has been built, simply start it with `docker start squid-service`

Codebase for the docker container can be found in [squid-service-docker](https://github.com/peavers/squid-service-docker)
