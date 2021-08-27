/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.produto.controle;

import entidade.categoriaproduto.modelo.CategoriaProdutoDAO;
import entidade.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioo
 */
public class ExcluirProdutoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        CategoriaProdutoDAO cpDAO = new CategoriaProdutoDAO();
        
        try {
            cpDAO.excluir(produtoId);
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(produtoDAO.deletar(produtoId)){
            request.setAttribute("mensagem","Produto excluído!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProdutos");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("mensagem","Não foi possível excluir o produto!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProdutos");
            requestDispatcher.forward(request, response);
        }
    }
}
