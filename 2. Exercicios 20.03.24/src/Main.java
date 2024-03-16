public class Main {
    public static void main(String[] args) throws Exception {
        JogadorGerador.realizarRequisicoes();
        Jogador jogador1 = JogadorGerador.gerarJogador();
        System.out.println(jogador1.getDescricao());

    }
}