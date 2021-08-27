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
import java.sql.SQLException;
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
public class AdicionarProdutoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        Produto p = new Produto();
        p.setDescricao(request.getParameter("descricao"));
        p.setPreco(Double.parseDouble(request.getParameter("preco")));
        p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

        ProdutoDAO produtoDAO = new ProdutoDAO();

        if (produtoDAO.inserir(p)) {
            p = produtoDAO.recuperar(produtoDAO.recuperarUltimoId());
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
        } else {
            request.setAttribute("mensagem", "Não foi possível registrar produto!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProdutos");
            requestDispatcher.forward(request, response);
        }
    }
}
