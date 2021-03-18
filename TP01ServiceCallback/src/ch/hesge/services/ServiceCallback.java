package ch.hesge.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


import javax.servlet.http.HttpServletResponse;


@Path("/serviceCallback")
public class ServiceCallback {

	@POST 
	@Path("/resultat")
	@Consumes(MediaType.TEXT_PLAIN)
	public void methode1(String requete,@Context HttpServletResponse response)   {
		System.out.println(requete);
		response.setStatus(HttpServletResponse.SC_OK); 
		try { 
			response.flushBuffer(); 
		}catch(Exception e){
		
		}
	}
}
