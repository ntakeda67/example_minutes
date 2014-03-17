package org.terash;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloResource {
	
	public HelloResource() {}
	
	@GET
	public String sayHello() {
		return "Hello Jax-RS!";
	}
	
    /** 
     * 与えられたパラメータに応じて「Parameter is '＜パラメータ＞'!」という文字列を返却します。 
     * 
     * @param param パラメータ 
     * @return パラメータを出力します。 
     */  
    @GET  
    @Path( "/{param:.*}" )  
    public String replayParameter( @PathParam( "param" ) String param ) {  
  
        return String.format( "Parameter is '%s'!", param );  
  
    }  
	
	
}
