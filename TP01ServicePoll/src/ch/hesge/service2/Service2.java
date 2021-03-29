package ch.hesge.service2;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import ch.hesge.db.Database;

@Path("/service2")
public class Service2 {

	@GET
	@Path("/number")
	public String methode1(@Context HttpServletResponse response)   {
		if(new Database().reponsePrete()) {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return "Le calcul est fait";
		}
		
		return null;
	}
}
