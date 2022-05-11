package ufrn.com.trabalho.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ufrn.com.trabalho.repository.Conexao;
import ufrn.com.trabalho.repository.ProdutoDAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("/Produto")
public class ProdutoController {

    ProdutoDAO ProduDao = new ProdutoDAO();

    @GetMapping("/listaProdutos")
    public void doListAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<table>");

        var produtoDao = new ProdutoDAO();
        var listaProdutos = produtoDao.listarProdutos();

        for (var p : listaProdutos) {
            writer.println("<tr>");
            writer.println("<td>");
            writer.println(p.getNome());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(p.getMarca());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(p.getPesagem());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(p.getPreco());
            writer.println("</td>");
            writer.println("<td>");
            writer.println("<a href='/adicionarCarrinho?id=" + p.getId() + "'>Adicionar</a>");
            writer.println("</td>");
            writer.println("</tr>");
        }

        writer.println("</table>");
        writer.println("</body></html>");
    }

    @GetMapping("/popula")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getConnection();
            stmt = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS produto (id SERIAL PRIMARY KEY, nome VARCHAR(55), marca VARCHAR(55), pesagem VARCHAR(55),preco FLOAT)");
            stmt.execute();

            stmt = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS usuario (id SERIAL PRIMARY KEY, nome VARCHAR (55), senha VARCHAR (55), cargo INTEGER)");
            stmt.execute();

            stmt = con
                    .prepareStatement("insert into produto (nome, descricao, preco) values\n"
                            + "('Mesa', 'Qualquer', '23.0'),\n"
                            + "('Caneta', 'Qualquer', '52.0'),\n"
                            + "('Cadeira', 'Qualquer', '10.0'),\n"
                            + "('TV', 'Dachshund', '75.0'),\n"
                            + "('Monitor', 'Qualquer', '110.0'),\n"
                            + "('Computador', 'Qualquer', '20.0')");
            stmt.execute();

            stmt = con
                    .prepareStatement("insert into usuario(nome, senha, adm) values\n" +
                            "('taniro', '123', true),\n" +
                            "('maria', '456', false)");
            stmt.execute();
            con.close();

            response.getWriter().println("ok");

        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().println(ex);
        }
    }
}