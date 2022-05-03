package ufrn.com.trabalho.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ufrn.com.trabalho.Persistencia.ProdutosDao;

@Controller
@RequestMapping("/cadastrar")
public class CadastroUsuarioController {

    ClienteDao ClienDao = new ProdutosDao();

    @PostMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        response.sendRedirect("/Main");
    }
}
