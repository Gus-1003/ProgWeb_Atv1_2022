package ufrn.com.trabalho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ufrn.com.trabalho.model.Produtos;
import ufrn.com.trabalho.repository.ProdutosDao;

@Controller
@RequestMapping("/Produto")
public class ProdutoController {

    ProdutosDao ProduDao = new ProdutosDao();

    @PostMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String pesagem = request.getParameter("pesagem");
        String preco = request.getParameter("preco");

        Produtos amostra = new Produtos(Integer.parseInt(id), nome, marca, pesagem, Float.parseFloat(preco));

        ProduDao.Cadastro(amostra);
        response.sendRedirect("/Main");
    }
}


// Cadastrar Produto - Responsabilidade do ADM
// --------------------------------------


// --------------------------------------



// Listar Produtos
// --------------------------------------


// --------------------------------------

