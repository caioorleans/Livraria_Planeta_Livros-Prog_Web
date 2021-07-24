package entidade.administrador.controle;

import entidade.administrador.modelo.Administrador;
import entidade.administrador.modelo.AdministradorDAO;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        /* processamento */
        AdministradorDAO administradorDAO = new AdministradorDAO();
        boolean loginValido = administradorDAO.efetuarLogin(login, senha);
        
        /* saída */
        if(loginValido){
            HttpSession session = request.getSession(true);
            Administrador adm = administradorDAO.obter(login);
            session.setAttribute("usuario", adm);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adm_principal.jsp");
            requestDispatcher.forward(request, response);
        }else{
            request.setAttribute("mensagem", "Login ou senha incorreta");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
