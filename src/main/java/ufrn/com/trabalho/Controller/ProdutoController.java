package ufrn.com.trabalho.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ufrn.com.trabalho.model.Produto;
import ufrn.com.trabalho.repository.Conexao;
import ufrn.com.trabalho.repository.ProdutoDAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class ProdutoController {

    @GetMapping("/listaprodutosUser")
    public void doListAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<table>");

        var produtoDao = new ProdutoDAO();
        var listaTotal = produtoDao.listaTotal();

        for (var p : listaTotal) {
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

    @GetMapping("/listaprodutosLojista")
    public void doListAllLojista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<table>");

        var produtoDao = new ProdutoDAO();
        var listaTotal = produtoDao.listaTotal();

        for (var p : listaTotal) {
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
        }

        writer.println("</table>");
        writer.println("</body></html>");
    }

    @GetMapping("/cadastroProduto")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Produto produto = new Produto();

        var nome = request.getParameter("nome");
        var marca = request.getParameter("marca");
        var pesagem = request.getParameter("pesagem");
        var preco = Float.parseFloat(request.getParameter("preco"));

        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setPesagem(pesagem);
        produto.setPreco(preco);

        ProdutoDAO.inserir(produto);

        response.sendRedirect("http://localhost:8080/logistaPage");
    }
}