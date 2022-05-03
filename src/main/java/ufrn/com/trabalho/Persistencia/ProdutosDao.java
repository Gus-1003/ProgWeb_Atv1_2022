package ufrn.com.trabalho.Persistencia;

import java.sql.*;
import java.util.ArrayList;

import ufrn.com.trabalho.Classes.Produtos;

public class ProdutosDao {

    private static Conexao conexao = new Conexao();
    private final String CREATE = " CREATE TABLE public.Produtos(" +
            " id character varying COLLATE pg_catalog.\"default\" NOT NULL," +
            " nome character varying COLLATE pg_catalog.\"default\"," +
            " marca character varying COLLATE pg_catalog.\"default\"," +
            " pesagem character varying COLLATE pg_catalog.\"default\", " +
            " preco character varying COLLATE pg_catalog.\"default\", " +
            "CONSTRAINT Produtos_pkey PRIMARY KEY (id));";

    public ProdutosDao() {
        conexao = new Conexao(System.getenv("DATABASE_HOST"), System.getenv("DATABASE_PORT"),
                System.getenv("DATABASE_NAME"), System.getenv("DATABASE_USERNAME"), System.getenv("DATABASE_PASSWORD"));
    }

    public void salvar(Produtos produto) {

        // estabelecer a conexao com o banco de dados
        try {
            conexao.conectar();

            PreparedStatement pst = conexao.getCon()
                    .prepareStatement("insert into Produto(id,nome,marca,pesagem,preco) values (?,?,?,?,?)");
            //pst.setString(1, produto.getId());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getMarca());
            pst.setString(4, produto.getPesagem());
            //pst.setInt(6, produto.getPreco());
            pst.execute();

            conexao.desconectar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProdutosDao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

    }

    public static ArrayList<Produtos> listar() {

        ArrayList<Produtos> array = new ArrayList<>();

        // estabelecer a conexao com o banco de dados
        try {
            conexao.conectar();
            PreparedStatement pst = conexao.getCon().prepareStatement("select * from Produtos");// o preapredStatement é
                                                                                            // responsavel por fazer uma
                                                                                            // inserção de dados de
                                                                                            // forma segura no banco
                                                                                            // através de uma String sql
                                                                                            // q é passada por parametro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //Produtos ali = new Produtos(rs.getString("id"), rs.getString("nome"), rs.getString("marca"),rs.getString("pesagem"), rs.getString("tipo"), rs.getInt("preco"));
                //array.add(ali);
            }
            conexao.desconectar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProdutosDao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        return array;
    }

    public void Cadastro() {

        try {
            conexao.conectar();
            Statement st = conexao.getCon().createStatement();
            st.execute(CREATE);
            conexao.desconectar();
        } catch (SQLException e) {
            System.out.println("erro" + e);
        }

    }

    public Produtos buscaId(String id) {

        // estabelecer a conexao com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produtos a = null;

        try {
            conexao.conectar();
            stmt = conexao.getCon().prepareStatement("select * from Produtos where id =? ");
            stmt.setString(1, (id));
            rs = stmt.executeQuery();

            if (rs.next()) {
                //a = new Produtos(rs.getString("id"), rs.getString("nome"), rs.getString("marca"), rs.getString("pesagem"), rs.getString("tipo"), rs.getInt("preco"));
            }
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }
}
