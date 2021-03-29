package ch.hesge.clientPoll;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.util.concurrent.*;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ClientMain {

	private static final String URL = "http://localhost:8080/TP01ServicePoll/service1/number";
	private static final String TAB = "     ";

	public static void main(String[] args) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		HttpResponse response = client.execute(request);

		if(response.getStatusLine().getStatusCode() == 303) {
			String location = response.getHeaders("Location")[0].getValue();
			
			request = new HttpGet(location);
			response = client.execute(request);

			int cpt = 0;
			
			do {
				System.out.println("Requête pas encore prête, veuillez patienter....");
				cpt++;
				client.execute(request);
			} while(response.getStatusLine().getStatusCode() != 200);
			
			System.out.println("La requête est prête après " + cpt + " Poll");
		}
	}
}
