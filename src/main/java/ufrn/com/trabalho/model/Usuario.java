package ufrn.com.trabalho.model;

public class Usuario {

// Atributos da Classe:
    int id; // Chave primaria - Identificação do usuario do sistema - Criação automatica dentro da tebela do banco
    
    
    // Atributos comuns a todos os usuarios: 
    String nome;
    String email;
    String senha;
    // --------------------------------------

    // Atributo que separa o cadastro entre as tebalas (Usuario e funcionario)
    int cargo;
    // --------------------------------------

    // Construtor da Classe
    public Usuario(int id, String nome, String email, String senha, int cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
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
    // --------------------------------------

                    // NOME
    // --------------------------------------
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // --------------------------------------


                    // EMAIL
    // --------------------------------------
    public String getEmail() {
        return email;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
    // --------------------------------------

                    // SENHA
    // --------------------------------------
    public String getSenha() {
        return senha;
    }
    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    // --------------------------------------

                    // CARGO
    // --------------------------------------
    public int getCargo() {
        return cargo;
    }
    public void setCargo(int Cargo) {
        this.cargo = Cargo;
    }
    // --------------------------------------
}
