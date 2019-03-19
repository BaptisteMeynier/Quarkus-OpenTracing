package org.acme.opentracing.portfolios.client;

import org.acme.opentracing.portfolios.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1")
@RegisterRestClient
public interface UsersService {
    @GET
    @Path("/user/{ptfcode}")
    @Produces("application/json")
    User getOwner(@PathParam("ptfcode") String ptfcode);
}
