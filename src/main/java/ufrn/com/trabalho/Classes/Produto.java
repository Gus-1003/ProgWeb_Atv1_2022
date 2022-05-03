package ufrn.com.trabalho.Classes;

public class Produto {

    int id;
    String nome;
    String marca;
    String pesagem;
    float preco;

    public Produto(int id, String nome, String marca, String pesagem, float preco) {
        super();
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.pesagem = pesagem;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPesagem() {
        return pesagem;
    }

    public void setPesagem(String pesagem) {
        pesagem = pesagem;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
