package ufrn.com.trabalho.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ufrn.com.trabalho.Classes.Produto;
import ufrn.com.trabalho.Persistencia.ProdutosDao;

@Controller
@RequestMapping("/cadastrar")
public class CadastroUsuarioController {

    ProdutosDao ProduDao = new ProdutosDao();

    @PostMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String pesagem = request.getParameter("pesagem");
        String preco = request.getParameter("preco");

        Produto mod = new Produto(Integer.parseInt(id), nome, marca, pesagem, Float.parseFloat(preco));

        ProduDao.salvar(mod);
        response.sendRedirect("/admin");
    }
}
