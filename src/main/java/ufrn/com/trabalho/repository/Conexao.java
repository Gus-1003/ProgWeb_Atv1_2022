package ufrn.com.trabalho.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    String url;
    String usuario;
    String senha;
    Connection conexao;

    public Conexao() {

    }

    public Conexao(String host, String porta, String db, String usuario, String senha) {
        this.url = "jdbc:postgresql://" + host + ':' + porta + "/" + db + "?serverTimezone=UTC";
        this.usuario = usuario;
        this.senha = senha;
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro na desconexão: " + e.getMessage());
        }
    }

    public Connection getCon() {
        return conexao;
    }
}
