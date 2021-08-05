package paginas.login.controle;

import entidade.administrador.modelo.Administrador;
import entidade.administrador.modelo.AdministradorDAO;
import entidade.cliente.modelo.Cliente;
import entidade.cliente.modelo.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caioo
 */
public class LoginBothServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        /* processamento */
        ClienteDAO clienteDAO = new ClienteDAO();
        boolean loginValido = clienteDAO.efetuarLogin(login, senha);
        /* saída */
        if (loginValido) {
            HttpSession session = request.getSession(true);
            Cliente cliente = clienteDAO.obter(login);
            session.setAttribute("usuario", cliente);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente_principal.jsp");
            requestDispatcher.forward(request, response);
        } else {
            AdministradorDAO administradorDAO = new AdministradorDAO();
            loginValido = administradorDAO.efetuarLogin(login, senha);
            if (loginValido) {
                HttpSession session = request.getSession(true);
                Administrador adm = administradorDAO.obter(login);
                session.setAttribute("usuario", adm);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adm_principal.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("mensagem", "Login ou senha incorreta");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
