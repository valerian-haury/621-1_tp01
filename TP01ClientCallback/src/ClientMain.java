import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ClientMain {

	public static void main(String[] args) throws Exception {

		String url = "http://localhost:8080/TP01ServiceCallback/service/calcule";
		String responseServiceUrl = "http://localhost:8080/TP01ServiceCallback/serviceCallback/resultat";


		HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(5)).build();

		HttpRequest request = HttpRequest.newBuilder().POST(BodyPublishers.ofString(url)).uri(URI.create(url))
				.setHeader("Content-Type", "text/plain").setHeader("Location", responseServiceUrl).build();

		CompletableFuture<HttpResponse<String>> asyncResponse = null;
		asyncResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

		int resultStatusCode = 0;

		try {
			resultStatusCode = asyncResponse.thenApply(HttpResponse::statusCode).get(5, TimeUnit.SECONDS);

		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		System.out.println("Status Code: " + resultStatusCode);

	}
}
