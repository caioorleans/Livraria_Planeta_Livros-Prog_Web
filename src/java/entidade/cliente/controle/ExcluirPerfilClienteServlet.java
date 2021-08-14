/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cliente.controle;

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
public class ExcluirPerfilClienteServlet extends HttpServlet {

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
        Cliente c = (Cliente)session.getAttribute("usuario");
        ClienteDAO clienteDAO = new ClienteDAO();
        
        if(clienteDAO.deletar(c.getId())){
            session.invalidate();
            request.setAttribute("mensagem","Seu perfil foi excluído.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("mensagem","Não foi possivel excluir perfil.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adm_principal.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
