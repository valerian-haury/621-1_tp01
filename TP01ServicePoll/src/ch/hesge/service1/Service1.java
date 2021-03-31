package ch.hesge.service1;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;

import ch.hesge.db.CalculeThread;

@Path("/service1")
public class Service1 {
	@GET
	@Path("/number")
	public String methode1(@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException {
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		response.setHeader("Location", "http://localhost:8080/TP01ServicePoll/service2/number");
		
		response.flushBuffer();
		
		new CalculeThread().run();
		
		return null;
	}
}
