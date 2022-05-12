package ufrn.com.trabalho.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String caminho;
    private String usuario;
    private String senha;
    private Connection conexao;

    public Conexao(String c, String u, String s) {
        this.caminho = c;
        this.usuario = u;
        this.senha = s;
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (Exception e) {
            System.out.println("Erro de conexão");
        }
    }

    public void desconectar() {
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}