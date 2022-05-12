package ufrn.com.trabalho.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ufrn.com.trabalho.model.Produto;

public class ProdutoDAO {

    static Conexao Link;

    private static final String INCLUIR = "insert into \"Produto\" (\"id_PK\", \"nome\", \"marca\", \"pesagem\", \"preco\") values (?,?,?,?,?)";
    private static final String RELATORIO = "select * from \"Produto\"";
    private static final String BUSCA = "select * from \"Produto\" where \"id_PK\"=?";

    public ProdutoDAO() {
        Link = new Conexao("jdbc:postgresql://localhost:5432/Prog_web", "postgres", "12345");
    }

    public ArrayList<Produto> listaTotal() {

        ArrayList<Produto> listaTotal = new ArrayList<>();
        Produto p = null;
        try {
            Link.conectar();

            Statement rule = Link.getConexao().createStatement();
            ResultSet rs = rule.executeQuery(RELATORIO);

            while (rs.next()) {
                p = new Produto(rs.getInt("id_PK"), rs.getString("nome"), rs.getString("marca"),
                        rs.getString("pesagem"), rs.getFloat("preco"));

                listaTotal.add(p);
            }

            Link.desconectar();

        } catch (SQLException e) {
            System.out.println("Falha na listagem total dos produtos: " + e.getMessage());
        }
        return listaTotal;
    }

    public static void inserir(Produto produto) {
        try {
            Link.conectar();

            PreparedStatement instrucao = Link.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, produto.getId());
            instrucao.setString(2, produto.getNome());
            instrucao.setString(3, produto.getMarca());
            instrucao.setString(4, produto.getPesagem());
            instrucao.setFloat(5, produto.getPreco());
            instrucao.execute();

            Link.desconectar();

        } catch (SQLException e) {
            System.out.println("Erro na Inclusão: " + e.getMessage());
        }
    }

    public Produto buscar(Integer id_PK) {

        Produto produto = null;

        try {
            Link.conectar();

            PreparedStatement instrucao = Link.getConexao().prepareStatement(BUSCA);
            instrucao.setInt(1, id_PK);
            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                produto = new Produto(rs.getInt("id_PK"), rs.getString("nome"), rs.getString("marca"),
                        rs.getString("pesagem"), rs.getFloat("preco"));
            }

            Link.desconectar();

        } catch (SQLException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return produto;
    }
}