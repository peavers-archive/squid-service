package space.squid.domain.resource;

import com.google.inject.Inject;
import space.squid.domain.repository.SignRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Endpoint resource for signing requests
 */
@Path("/sign-upload")
@Produces("application/json")
@Consumes("application/json")
public class SignResource {

    private final SignRepository repository;

    /**
     * @param repository SignRepository
     */
    @Inject
    public SignResource(final SignRepository repository) {
        this.repository = repository;
    }

    /**
     * @param filename String filename to give the asset on S3
     * @param type     String content type of the asset being uploaded
     * @return Response
     */
    @GET
    public Response signRequest(final @QueryParam("name") String filename, final @QueryParam("type") String type) {
        String signRequest = repository.signRequest(filename, type);
        return Response.status(Response.Status.OK).entity(signRequest).build();
    }
}
