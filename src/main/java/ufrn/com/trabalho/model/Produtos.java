package ufrn.com.trabalho.model;

public class Produtos {

// Atributos da Classe:
    int id; // Chave primaria - Identificação do produto do sistema - Criação automatica dentro da tebela do banco

    // Atributos comuns entre todos os produtos:
    String nome;
    String marca;
    String pesagem;
    float preco;
    // --------------------------------------


    // Construtor da Classe    
    public Produtos(int id, String nome, String marca, String pesagem, float preco) {
        super();
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.pesagem = pesagem;
        this.preco = preco;
    }
    // --------------------------------------

// Métodos da classe:
                    // ID
    // --------------------------------------    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

                    // NOME
    // --------------------------------------
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // --------------------------------------

                    // MARCA
    // --------------------------------------    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    // --------------------------------------

                    // PESAGEM
    // --------------------------------------
    public String getPesagem() {
        return pesagem;
    }
    public void setPesagem(String pesagem) {
        this.pesagem = pesagem;
    }
    // --------------------------------------

                    // CARGO
    // --------------------------------------
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    // --------------------------------------
}
