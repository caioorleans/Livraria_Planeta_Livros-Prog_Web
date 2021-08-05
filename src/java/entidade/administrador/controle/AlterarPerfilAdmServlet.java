/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AlterarPerfilAdmServlet extends HttpServlet {

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
        
        Administrador a = new Administrador();
        HttpSession session = request.getSession(true);
        
        a.setNome(request.getParameter("nome"));
        a.setEmail(request.getParameter("email"));
        a.setLogin(request.getParameter("login"));
        a.setSenha(request.getParameter("senha"));
        a.setId(((Administrador)session.getAttribute("usuario")).getId());
        
        /* processamento */
        
        AdministradorDAO administradorDAO = new AdministradorDAO();
        try{
            if(administradorDAO.atualizar(a)){
                request.setAttribute("mensagem","Cadastro atualizado com sucesso!");
                session.setAttribute("usuario", a);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adm_principal.jsp");
                requestDispatcher.forward(request, response);
            }
            else{
                request.setAttribute("mensagem","Não foi possível atualizar os dados do cliente.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adm_principal.jsp");
                requestDispatcher.forward(request, response);
            }
        }catch(Exception ex){
            request.setAttribute("mensagem","Não foi possível atualizar os dados do cliente.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adm_principal.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
