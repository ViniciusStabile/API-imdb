package App;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Fazer coneção HTTP e buscar os top 10 filmes
		//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";

		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		
		var http = new ClienteHttp(url);
		String body = http.buscaDados();

		// Exibir e manipular os dados
		ExtratorConteudo extrator = new extratorConteudoImdb();
		List<conteudo> conteudos = extrator.extraiConteudos(body);

		GeradorFigurinhas GF = new GeradorFigurinhas();

		for (conteudo conteudo : conteudos) {

			InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
			GF.cria(inputStream, conteudo.getTitulo());

			System.out.println("Titulo: " + conteudo.getTitulo());

			System.out.println("URL poster: " + conteudo.getUrlImage());
			System.out.println();

		}

	}

}
