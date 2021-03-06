/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.produto.controle;

import entidade.produto.modelo.Produto;
import entidade.produto.modelo.ProdutoDAO;
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
public class AtualizarProdutoServlet extends HttpServlet {

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
        p.setId(Integer.parseInt(request.getParameter("id")));
        p.setDescricao(request.getParameter("descricao"));
        p.setPreco(Double.parseDouble(request.getParameter("preco")));
        p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProdutos");
        
        if(produtoDAO.atualizar(p)){
            request.setAttribute("mensagem", "Dados de produto atualizados com sucesso");   
        }
        else{
            request.setAttribute("mensagem", "Não foi possível atualizar os dados do produto");
        }
        requestDispatcher.forward(request, response);
    }
}
