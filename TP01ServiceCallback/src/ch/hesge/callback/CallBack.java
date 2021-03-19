package ch.hesge.callback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class CallBack  extends Thread{
	private String url;
	
	
	public CallBack(String url) {
		super();
		this.url = url;
	}

	//Ne pas modifier cette méthode
	public void run() {

	System.out.println("==>callBackProcess()");

	System.out.println("==> simulation d'un long calcule......");
	int cpt=0;
	while (cpt<9000000) {
		cpt++;
		int cpt2=0;
		while (cpt2<900) {
			cpt2++;
			int cpt3=0;
			while (cpt3<4) {
				cpt3++;
			}
		}
	}
	envoieCallback(url);
	}
	
	//Méthode a  modifier
	public  void envoieCallback(String url) {
		URL httpUrl;
		HttpURLConnection conn;
		try {
			httpUrl = new URL(url);
			conn = (HttpURLConnection)httpUrl.openConnection();
			conn.setRequestProperty("Content-Type", "text/plain");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			writer.write("La réponse envoyée");
			writer.close();
			conn.getInputStream();
			conn.connect();
		} catch (IOException e) {
			System.err.println(e);
		}	
	}
}
