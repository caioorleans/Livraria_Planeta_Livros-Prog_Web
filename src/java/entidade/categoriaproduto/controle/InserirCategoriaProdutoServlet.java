/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.categoriaproduto.controle;

import entidade.categoriaproduto.modelo.CategoriaProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioo
 */
public class InserirCategoriaProdutoServlet extends HttpServlet {

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
        int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));
        CategoriaProdutoDAO produtoCategoriaDAO = new CategoriaProdutoDAO();
        try {
            produtoCategoriaDAO.inserir(produtoId, categoriaId);
            request.setAttribute("mensagem", "Categoria vinculada ao produto");
        } catch (SQLException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditarProduto?produtoId=" + produtoId);
        dispatcher.forward(request, response);
    }

}
