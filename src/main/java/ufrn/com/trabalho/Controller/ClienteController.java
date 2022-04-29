package ufrn.com.trabalho.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/cadastrocliente", method = RequestMethod.GET)
    public void docadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var nome = request.getParameter("nome");
        var idade = request.getParameter("idade");
        var prefs = request.getParameterValues("prefs");

        var writer = response.getWriter();

        writer.println(nome);
        writer.println(idade);

        for (var p : prefs) {
            writer.println(prefs);
        }
    }
}