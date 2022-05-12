package ufrn.com.trabalho.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.com.trabalho.model.Produto;
import ufrn.com.trabalho.model.Usuario;
import ufrn.com.trabalho.repository.UsuarioDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UsuarioController {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Integer logIdUser = 0;

    // Método responsavel por voltar para o login:
    @PostMapping("/login")
    public void redirecionarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/login.html");
    }

    // Método responsavel pelas ações do formulario de cadastro do cliente:
    @GetMapping("/cadastroUsuario")
    public void doCadastroUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var nome = request.getParameter("nome");
        var senha = request.getParameter("senha");
        var email = request.getParameter("email");

        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);

        usuario.setCargo(1);

        usuarioDAO.cadastrar(usuario);

        response.sendRedirect("http://localhost:8080/login.html");
    }

    /*@GetMapping(value = "/verificarAcesso" )
    public void doverificarAcesso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        throws IOException, ServletException{

            HttpSession session = request.getSession();

            var email = request.getParameter("email");
            var senha = request.getParameter("senha");

            var usuario2 = new Usuario();

            usuario2 = usuarioDAO.buscar(email, senha);

            if (usuario2 == null) {
                response.sendRedirect("http://localhost:8080/falhaLogin");
            } else {
                if (usuario2.getTipo() == 1) {// Usuário Cliente
                    session.setAttribute("usuarioClienteLogado", usuario2.getNome());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/telaCliente");
                    dispatcher.forward(request, response);
                } else {
                    session.setAttribute("NomeUser", usuario2.getNome());// Usuario Logista
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/telaLogista");
                    dispatcher.forward(request, response);
                }
            }
        }
    }*/

    @PostMapping("/falhaLogin")
    public void doFalhaLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("login");
    }

    @GetMapping("/userPage")
    public void doUserPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Página de usuario");
    }

    @GetMapping("/logistaPage")
    public void doLogistaPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Página de admin");
    }

    @GetMapping(value = "/cadastroFuncionario")
    public void doCadastroFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("cadastroFuncionario");
    }
}