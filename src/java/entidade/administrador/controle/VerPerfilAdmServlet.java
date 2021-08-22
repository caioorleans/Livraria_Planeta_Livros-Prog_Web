/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.administrador.controle;

import entidade.administrador.modelo.Administrador;
import entidade.administrador.modelo.AdministradorDAO;
import java.io.IOException;
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
public class VerPerfilAdmServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdministradorDAO administradorDAO = new AdministradorDAO();
        Administrador admin = (Administrador) session.getAttribute("usuario");
        Administrador administrador = administradorDAO.obter(admin.getLogin());
        request.setAttribute("usuario", administrador);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/perfil_adm.jsp");
        requestDispatcher.forward(request, response);
    }
}
