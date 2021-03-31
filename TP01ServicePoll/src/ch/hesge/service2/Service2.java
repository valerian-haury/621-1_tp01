package ch.hesge.service2;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import ch.hesge.db.Database;

@Path("/service2")
public class Service2 {

	@GET
	@Path("/number")
	public String methode1(@Context HttpServletResponse response) throws IOException   {
		boolean reponsePrete= new Database().reponsePrete();
		
		if(reponsePrete) {
			response.setStatus(HttpServletResponse.SC_OK);
			
			response.flushBuffer();
			
			return "Le calcul est fait";
		}
		
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		response.flushBuffer();
		
		return null;
	}
}
