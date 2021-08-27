/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.categoria.controle;

import entidade.categoria.modelo.Categoria;
import entidade.categoria.modelo.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioo
 */
public class BuscarCategoriaAdmServlet extends HttpServlet {

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
        String descricao = request.getParameter("descricao");
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = null;
        categorias = categoriaDAO.recuperarPorNome(descricao);
        request.setAttribute("categorias", categorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/listagem_de_categorias.jsp");
        dispatcher.forward(request, response);
    }

}
