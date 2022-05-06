package ufrn.com.trabalho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/Main")     // Pagina Principal - Responsavel pelo login - Deve ser associado a um método "Validação" na classe DAO de cliente;
public class MainController {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //String email, senha;

        response.getWriter().println(" <!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/cadastrar\"  method=\"post\">\n" +
                "    Email: <input type=\"text\" name=\"email\"> <br />\n" +
                "    Senha: <input type=\"text\" name=\"senha\"><br />\n" +
                "    \n" +
                "    <button type=\"submit\">Enviar</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

            HttpSession session = request.getSession();

            var out = response.getWriter();
            var dataCriacao = new Date(session.getCreationTime());
            var formatData = new SimpleDateFormat("dd/MM/yyyy--hh:mm:ss");

            Cookie c = new Cookie("login", email);
            c.setMaxAge(60*60*24);
            response.addCookie(c);
            out.println("Ultimo acesso: " + formatData.format(dataCriacao));
    }
}
