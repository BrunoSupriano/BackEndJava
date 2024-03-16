import java.net.URI;
import java.util.Random;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JogadorGerador {
    private static String[] nomes;
    private static String[] clubes;
    private static String[] posicoes;
    private static final Random random = new Random();

    public static void realizarRequisicoes() throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicaoNomes = HttpRequest.newBuilder().uri(URI.create("https://venson.net.br/resources/data/nomes.txt")).build();
        HttpRequest requisicaoClubes = HttpRequest.newBuilder().uri(URI.create("https://venson.net.br/resources/data/clubes.txt")).build();
        HttpRequest requisicaoPosicoes = HttpRequest.newBuilder().uri(URI.create("https://venson.net.br/resources/data/posicoes.txt")).build();

        HttpResponse<String> respostaNomes = cliente.send(requisicaoNomes, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> respostaClubes = cliente.send(requisicaoClubes, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> respostaPosicoes = cliente.send(requisicaoPosicoes, HttpResponse.BodyHandlers.ofString());

        nomes = respostaNomes.body().split("\n");
        clubes = respostaClubes.body().split("\n");
        posicoes = respostaPosicoes.body().split("\n");
    }

    public static Jogador gerarJogador() {
        String nome = nomes[random.nextInt(nomes.length)];
        int idade = random.nextInt(24) + 17;
        String clube = clubes[random.nextInt(clubes.length)];
        String posicao = posicoes[random.nextInt(posicoes.length)].replace(" ", "").replace(",", "");
        return new Jogador(nome, idade, clube, posicao);
    }
}

