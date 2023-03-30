package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorConteudoImdb implements ExtratorConteudo {

	public List<conteudo> extraiConteudos(String body) {

		// Pegando os dados que me interessam(Titulo, classificação,poster)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(body);

		List<conteudo> conteudos = new ArrayList<>();

		// Popular a lista de conteudos
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("image");

			var Conteudo = new conteudo(titulo, urlImagem);

			conteudos.add(Conteudo);
		}
		return conteudos;
	}

}
