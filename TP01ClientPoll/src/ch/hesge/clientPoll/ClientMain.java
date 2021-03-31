package ch.hesge.clientPoll;

import java.io.IOException;
import java.util.concurrent.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.servlet.http.HttpServletResponse;

public class ClientMain {

	private static final String URL = "http://localhost:8080/TP01ServicePoll/service1/number";

	public static void main(String[] args) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		HttpResponse response = client.execute(request);

		if(response.getStatusLine().getStatusCode() == 202) {
			String location = response.getHeaders("Location")[0].getValue();
			
			request = new HttpGet(location);
			response = client.execute(request);

			int cpt = 0;
			
			do {
				cpt++;
				System.out.println(cpt + " - Requête pas encore prête, veuillez patienter....");
			} while(check(location) == false);
			
			System.out.println("La requête est prête après " + cpt + " Poll");
		}
	}
	
	private static boolean check(String url) throws ClientProtocolException, IOException, InterruptedException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		
		TimeUnit.MILLISECONDS.sleep(200);
		
		if (response.getStatusLine().getStatusCode() == HttpServletResponse.SC_OK) {
			return true;
		}

		return false;
	}
}
