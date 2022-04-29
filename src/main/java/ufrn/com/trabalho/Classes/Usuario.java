package ufrn.com.trabalho.Classes;

public class Usuario {

    int id;
    String nome;
    String email;
    String senha;
    int cargo;

    public Usuario(int id, String nome, String email, String senha, int cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String Senha) {
        senha = Senha;
    }

    public int getCargo() {
        return cargo;
    }
    public void setCargo(int Cargo) {
        cargo = Cargo;
    }
}
