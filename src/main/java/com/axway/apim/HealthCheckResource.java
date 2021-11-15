package com.axway.apim;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("health")
public class HealthCheckResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorld() {
        return Response.ok("healthy").build();
    }
}
