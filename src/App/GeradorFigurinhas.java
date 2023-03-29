package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

		// Leitura da imagem
		//InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg").openStream();

		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		// Criar nova imagem com transparencia e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();

		int NovaAltura = altura + 200;

		BufferedImage novaImagem = new BufferedImage(largura, NovaAltura, BufferedImage.TRANSLUCENT);

		// copiar a imagem real para nova imagem(em memoria)

		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		// Configurar Fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 75);
		graphics.setColor(Color.RED);
		graphics.setFont(fonte);

		// Escrever uma frase na imagem

		graphics.drawString("Topzera", 215, NovaAltura - 100);

		// Escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo + ".png"));

	}

}
