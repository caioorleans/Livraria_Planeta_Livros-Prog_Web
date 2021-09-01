/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.compra.controle;

import entidade.cliente.modelo.Cliente;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author caioo
 */
public class VerComprasClienteServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        int id = ((Cliente) session.getAttribute("usuario")).getId();
        CompraDAO compraDAO = new CompraDAO();
        ProdutoCompraDAO pcDAO = new ProdutoCompraDAO();
        ArrayList<Compra> compras = compraDAO.recuperarCompras(id);
        for (int i = 0; i < compras.size(); i++) {
            compras.get(i).setProdutos(pcDAO.recuperarPorCompra(compras.get(i).getId()));
        }
        request.setAttribute("compras", compras);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/cliente_compras.jsp");
        requestDispatcher.forward(request, response);
    }
}
