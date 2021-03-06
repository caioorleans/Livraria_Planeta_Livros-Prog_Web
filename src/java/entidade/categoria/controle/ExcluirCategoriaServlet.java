/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.categoria.controle;

import entidade.categoria.modelo.CategoriaDAO;
import entidade.categoriaproduto.modelo.CategoriaProdutoDAO;
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
public class ExcluirCategoriaServlet extends HttpServlet {

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
        
        int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        CategoriaProdutoDAO cpDAO = new CategoriaProdutoDAO();
        
        try {
            cpDAO.excluirPorCategoria(categoriaId);
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirCategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(categoriaDAO.deletar(categoriaId)){
            request.setAttribute("mensagem","Categoria excluída!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarCategorias");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("mensagem","Não foi possível excluir a categoria!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarCategorias");
            requestDispatcher.forward(request, response);
        }
    }
}
