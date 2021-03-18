package ch.hesge.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


import javax.servlet.http.HttpServletResponse;


@Path("/")
public class ServiceCallback {

	@POST 
	@Path("resultat")
	@Consumes(MediaType.TEXT_PLAIN)
	public void methode1(String requete,@Context HttpServletResponse response)   {
		System.out.println(requete);
		response.setStatus(HttpServletResponse.SC_OK); 
		try { 
			response.flushBuffer(); 
		}catch(Exception e){
		
		}
	}
	
	@GET 
	@Path("hop")
	@Produces (MediaType.TEXT_HTML)
	public String getHop()   {
		System.out.println("hop");
		return "<h1>HOP</h1>";
	}
	
	@GET 
	@Path("hop/{text}")
	@Produces (MediaType.TEXT_HTML)
	@Consumes (MediaType.TEXT_PLAIN)
	public String getHop(String payload,@PathParam("text") String text)   {
		System.out.println("hop " + text);
		return "<h1>hop "+ text +"</h1>";
	}
}