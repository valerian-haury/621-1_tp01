package ch.hesge.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.http.client.ClientProtocolException;
import ch.hesge.callback.CallBack;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Path("/service")
public class Service {

	// A  implementer
	@POST 
	@Path("/calcule")
	public void calcul(@Context HttpServletRequest request ,@Context HttpServletResponse response)   {
		response.setContentType("text/plain");
		response.setStatus(HttpServletResponse.SC_SEE_OTHER);
		String url = request.getHeader("Location");
		new CallBack(url).start();
		try { 
			response.flushBuffer(); 
		}catch(Exception e){
		
		}
	}

}
