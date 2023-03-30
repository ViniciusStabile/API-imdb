package App;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {

	private String url;

	public ClienteHttp(String url) {
		this.url = url;
	}

	// Chamar cliente Http
	public String buscaDados() {

		try {
			URI endereço = URI.create(url);
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(endereço).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String body = response.body();
			return body;

		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException(ex);

		}
	}

}
