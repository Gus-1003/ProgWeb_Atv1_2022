package ufrn.com.trabalho.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CadastroUsuarioController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void dologin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var aula = request.getParameter("aula");

        String admin = servletContext.getInitParameter("admin");
        String teste = servletContext.getInitParameter("aula");

        response.setContentType("text/html");
        response.setStatus(210);
        response.getWriter().println("<html><body>Hello world " + aula + " admin:" + admin + teste + "</body></html>");
    }
}
