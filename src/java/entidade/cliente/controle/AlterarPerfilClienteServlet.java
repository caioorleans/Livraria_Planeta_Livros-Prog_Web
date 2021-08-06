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
public class AlterarPerfilClienteServlet extends HttpServlet {

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
        Cliente c = new Cliente();
        HttpSession session = request.getSession(true);
        
        c.setNome(request.getParameter("nome"));
        c.setEndereco(request.getParameter("endereco"));
        c.setEmail(request.getParameter("email"));
        c.setLogin(request.getParameter("login"));
        c.setSenha(request.getParameter("senha"));
        c.setId(((Cliente)session.getAttribute("usuario")).getId());
        
        /* processamento */
        
        ClienteDAO clienteDAO = new ClienteDAO();
        try{
            if(clienteDAO.atualizar(c)){
                request.setAttribute("mensagem","Cadastro atualizado com sucesso!");
                session.setAttribute("usuario", c);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente_principal.jsp");
                requestDispatcher.forward(request, response);
            }
            else{
                request.setAttribute("mensagem","Não foi possível atualizar os dados do cliente.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/perfil_cliente.jsp");
                requestDispatcher.forward(request, response);
            }
        }catch(Exception ex){
            request.setAttribute("mensagem","Não foi possível atualizar os dados do cliente.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/perfil_cliente.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
