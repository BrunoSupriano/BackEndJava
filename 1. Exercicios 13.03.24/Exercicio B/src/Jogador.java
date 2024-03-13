public class Jogador {
    private String nome;
    private int idade;
    private String clube;
    private String posicao;

    public Jogador(String nome, int idade, String clube, String posicao) {
        this.nome = nome;
        this.idade = idade;
        this.clube = clube;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getClube() {
        return clube;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getDescricao() {
        return String.format("%s é um futebolista brasileiro de %d anos que atua como %s. Atualmente defende o %s.", nome, idade, posicao, clube);
    }
}