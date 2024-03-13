import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static String retornaTextoDoServidor(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        String texto = resposta.body();
        return texto;
    }
    public static String retornaElementoAleatorio(String texto) {
        String[] listaDeNomes = texto.split("\n");
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    public static void main(String[] args) throws Exception {
        //nomes
        String textoNomes = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
        String nome = retornaElementoAleatorio(textoNomes);
        //idade
        int idade = (int) (Math.random() * 24) + 17;
        //clubes
        String textoClubes = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
        String clube = retornaElementoAleatorio(textoClubes);
        //posição
        String textoPosicoes = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
        String posicao = retornaElementoAleatorio(textoPosicoes).replace(" ", "").replace(",", "");
        //prints

        System.out.printf("%s é um futebolista brasileiro de %d anos que atua como %s. Atualmente defende o %s.\n", nome, idade, posicao, clube);

    }
}