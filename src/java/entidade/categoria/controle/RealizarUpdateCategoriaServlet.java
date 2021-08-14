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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioo
 */
public class RealizarUpdateCategoriaServlet extends HttpServlet {

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

        Categoria c = new Categoria();
        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setDescricao(request.getParameter("descricao"));

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        if (categoriaDAO.atualizar(c)) {
            request.setAttribute("mensagem", "Update atualizado com sucesso!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarCategorias");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("mensagem", "Não foi possível realizar o update!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarCategorias");
            requestDispatcher.forward(request, response);
        }
    }
}
