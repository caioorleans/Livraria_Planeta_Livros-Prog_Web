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

/**
 *
 * @author caioo
 */
public class CadastrarClienteServlet extends HttpServlet {

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
            throws ServletException, IOException{
        /* entrada */
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        /* processamento */
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setEndereco(endereco);
        c.setEmail(email);
        c.setLogin(login);
        c.setSenha(senha);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        try{
            clienteDAO.inserir(c);
            request.setAttribute("mensagem","Cadastro realizado com sucesso!");
        }catch(Exception ex){
            request.setAttribute("mensagem","Não foi possível cadastrar o cliente.");
        }
        
        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastrar_cliente.jsp");
        requestDispatcher.forward(request, response);
    }
}
