package App;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Fazer coneção HTTP e buscar os top 10 filmes
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereço = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereço).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String Body = response.body();
		// System.out.println(Body);

		// Pegando os dados que me interessam(Titulo, classificação,poster)
		JsonParser parser = new JsonParser();

		List<Map<String, String>> listaDeFilmes = parser.parse(Body);

		// Exibir e manipular os dados
		GeradorFigurinhas GF = new GeradorFigurinhas();
		for (Map<String, String> filmes : listaDeFilmes) {
			
			String urlFilme = filmes.get("image");
			String nomeFilme = filmes.get("title");
			
			InputStream inputStream = new URL(urlFilme).openStream();
			GF.cria(inputStream, nomeFilme);
			
			System.out.println("Titulo: " + filmes.get("title"));
			System.out.println("Rank: " + filmes.get("rank"));
			System.out.println("URL poster: " + filmes.get("image"));
			System.out.println();

		}

	}

}
