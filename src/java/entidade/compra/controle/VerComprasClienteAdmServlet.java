/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.compra.controle;

import entidade.compra.modelo.Compra;
import entidade.compra.modelo.CompraDAO;
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
public class VerComprasClienteAdmServlet extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("idCliente"));
        
        CompraDAO compraDAO = new CompraDAO();
        ProdutoCompraDAO pcDAO = new ProdutoCompraDAO();
        ArrayList<Compra> compras = compraDAO.recuperarCompras(id);
        for (int i = 0; i < compras.size(); i++) {
            compras.get(i).setProdutos(pcDAO.recuperarPorCompra(compras.get(i).getId()));
        }
        request.setAttribute("compras", compras);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/ver_cliente_compras.jsp");
        requestDispatcher.forward(request, response);
    }
}
