package ufrn.com.trabalho.repository;

import java.sql.*;
import java.util.ArrayList;

import ufrn.com.trabalho.model.Usuario;

public class ClienteDao {

                        // Instacia um objeto conexão
    // ----------------------------------------------------------------------------
    private static Conexao conexao = new Conexao();

                        // Desenvolve 
    // ----------------------------------------------------------------------------
    private final String CREATE = " CREATE TABLE public.Cliente(" +
            " Id_Pk character varying COLLATE pg_catalog.\"default\" NOT NULL," +
            " nome character varying COLLATE pg_catalog.\"default\"," +
            " email character varying COLLATE pg_catalog.\"default\"," +
            " senha character varying COLLATE pg_catalog.\"default\", " +
            "CONSTRAINT Cliente_pkey PRIMARY KEY (Id_Pk));";


    public ClienteDao() {
        conexao = new Conexao(System.getenv("DATABASE_HOST"), 
            System.getenv("DATABASE_PORT"),
            System.getenv("DATABASE_NAME"),
            System.getenv("DATABASE_USERNAME"),
            System.getenv("DATABASE_PASSWORD"));
    }

// Métodos:

            // Listar todos os Usuarios / Funcionarios
    // -------------------------------------------------------------    
    public static ArrayList<Usuario> listar() {

        ArrayList<Usuario> array = new ArrayList<>();

        // estabelecer a conexao com o banco de dados
        try {
            conexao.conectar();
            PreparedStatement pst = conexao.getCon().prepareStatement("select * from Usuario");// o preapredStatement é
                                                                                            // responsavel por fazer uma
                                                                                            // inserção de dados de
                                                                                            // forma segura no banco
                                                                                            // através de uma String sql
                                                                                            // q é passada por parametro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //Usuario ali = new Usuario(rs.getString("id"), rs.getString("nome"), rs.getString("marca"),rs.getString("pesagem"), rs.getString("tipo"), rs.getInt("preco"));
                //array.add(ali);
            }
            conexao.desconectar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        return array;
    }

            // Cadastrar Funcionarios
    // -------------------------------------------------------------   
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

                // Buscar por ID
    // -------------------------------------------------------------   
    public Usuario buscaId(String id) {

        // estabelecer a conexao com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario a = null;

        try {
            conexao.conectar();
            stmt = conexao.getCon().prepareStatement("select * from Cliente where id =? ");
            stmt.setString(1, (id));
            rs = stmt.executeQuery();

            if (rs.next()) {
                //a = new Cliente(rs.getString("id"), rs.getString("nome"), rs.getString("marca"), rs.getString("pesagem"), rs.getString("tipo"), rs.getInt("preco"));
            }
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }
}
