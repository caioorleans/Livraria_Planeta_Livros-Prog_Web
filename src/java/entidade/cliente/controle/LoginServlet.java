package entidade.cliente.controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidade.cliente.modelo.Cliente;
import entidade.cliente.modelo.ClienteDAO;

/**
 *
 * @author caioo
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente)session.getAttribute("usuario");
        request.setAttribute("login", cliente.getLogin());
        request.setAttribute("senha", cliente.getSenha());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login");
        requestDispatcher.forward(request, response);
    }

}
