package com.axway.apim;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class HealthCheckResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(HealthCheckResource.class).register(InjectHeaderFilter.class);
    }

    @Test
    public void testHealthCheck(){
        Response response = target("/health").request()
                .get();

        Assert.assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getHeaders());

        Assert.assertEquals("Axway API Gateway", response.getHeaderString("X-Jersey-Header"));

        String content = response.readEntity(String.class);
        Assert.assertEquals("Content of ressponse is: ", "healthy", content);



    }
}
