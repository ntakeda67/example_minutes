package org.terash;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class TestResource {

	@GET
	public String sayTest() {
		return "Jax-RS Test!!";
	}
	
	
	
}
