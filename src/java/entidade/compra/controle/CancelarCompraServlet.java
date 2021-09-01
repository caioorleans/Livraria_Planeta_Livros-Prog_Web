/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.compra.controle;

import entidade.compra.modelo.CompraDAO;
import entidade.produto.modelo.Produto;
import entidade.produto.modelo.ProdutoDAO;
import entidade.produtocompra.modelo.ProdutoCompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioo
 */
public class CancelarCompraServlet extends HttpServlet {

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
        
        int idCompra = Integer.parseInt(request.getParameter("idCompra"));
        ProdutoCompraDAO pcDAO = new ProdutoCompraDAO();
        ArrayList<Produto> produtos = pcDAO.recuperarPorCompra(idCompra);
        if(!produtos.isEmpty()){
            ProdutoDAO produtoDAO = new ProdutoDAO();
            for(int i = 0; i < produtos.size(); i++){
                produtoDAO.adicionarDoEstoque(produtos.get(i), produtos.get(i).getQuantidade());
            }
        }
        CompraDAO compraDAO = new CompraDAO();
        compraDAO.excluir(idCompra);
        
        request.setAttribute("Mensagem", "Compra excluída com sucesso!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarClientes");
        requestDispatcher.forward(request, response);
    }
}
