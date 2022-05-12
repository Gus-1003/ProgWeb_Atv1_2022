package ufrn.com.trabalho.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ufrn.com.trabalho.model.Usuario;

public class UsuarioDAO {

    Conexao link;

    private static final String INCLUIR = "insert into \"Usuario\" (\"Id_Pk\", \"nome\", \"senha\", \"email\", \"tipo\") values (?,?,?,?,?)";
    private static final String BUSCA = "select * from \"Usuario\" where \"email\"=? and \"senha\"=?";

    public UsuarioDAO() {
        link = new Conexao("jdbc:postgresql://localhost:5432/Prog_web", "postgres", "12345");
    }

    public void cadastrar(Usuario usuario) {
        try {
            link.conectar();

            PreparedStatement instrucao = link.getConexao().prepareStatement(INCLUIR);

            instrucao.setInt(1, usuario.getId());
            instrucao.setString(2, usuario.getNome());
            instrucao.setString(3, usuario.getSenha());
            instrucao.setString(4, usuario.getEmail());
            instrucao.setInt(5, usuario.getTipo());

            instrucao.execute();

            link.desconectar();

        } catch (SQLException e) {
            System.out.println("Erro na Inclusão: " + e.getMessage());
        }
    }

    public Usuario buscar(String email, String senha) {

        Usuario usuario = null;

        try {
            link.conectar();
            PreparedStatement instrucao = link.getConexao().prepareStatement(BUSCA);

            instrucao.setString(1, email);
            instrucao.setString(2, senha);

            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(rs.getInt("Id_PK"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("cargo"));
            }

            link.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return usuario;
    }
}
