/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.produto.controle;

import entidade.categoria.modelo.Categoria;
import entidade.categoria.modelo.CategoriaDAO;
import entidade.produto.modelo.Produto;
import entidade.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class EditarProdutoServlet extends HttpServlet {

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

        int idProduto = Integer.parseInt(request.getParameter("produtoId"));

        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto p = produtoDAO.recuperar(idProduto);

        if (p != null) {
            request.setAttribute("produto", p);
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List<Categoria> categorias = null;
            categorias = categoriaDAO.recuperarTodas();
            if (categorias == null) {
                categorias = new ArrayList<Categoria>();
            }
            request.setAttribute("categorias", categorias);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/atualizar_dados_produto.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Produto não encontrado");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/listagem_de_produtos.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
