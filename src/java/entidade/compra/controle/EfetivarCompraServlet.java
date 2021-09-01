/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.compra.controle;

import entidade.carrinhocompra.modelo.CarrinhoCompra;
import entidade.carrinhocompra.modelo.CarrinhoCompraItem;
import entidade.cliente.modelo.Cliente;
import entidade.compra.modelo.CompraDAO;
import entidade.produto.modelo.ProdutoDAO;
import entidade.produtocompra.modelo.ProdutoCompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caioo
 */
public class EfetivarCompraServlet extends HttpServlet {

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

        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("ufcsmdecommerce.carrinhocompras")) {
                cookie = cookies[i];
                break;
            }
        }
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);

        List<CarrinhoCompraItem> carrinhoCompraItens = CarrinhoCompra.obterCarrinhoCompra(cookie.getValue());
        HttpSession session = request.getSession(true);
        if (session == null || session.getAttribute("usuario") == null) {
            request.setAttribute("mensagem", "Você não tem uma sessão válida de usuário");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
            requestDispatcher.forward(request, response);
        } else {
            if (session.getAttribute("usuario") instanceof Cliente) {
                Cliente c = (Cliente) session.getAttribute("usuario");
                CompraDAO compraDAO = new CompraDAO();
                Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
                if (compraDAO.inserir(c.getId(), dataDeHoje)) {
                    ProdutoCompraDAO pcDAO = new ProdutoCompraDAO();
                    int idCompra = compraDAO.recuperarUltimoId();
                    for (int i = 0; i < carrinhoCompraItens.size(); i++) {
                        CarrinhoCompraItem cci = carrinhoCompraItens.get(i);
                        if (pcDAO.inserir(idCompra, cci.getProduto(), cci.getQuantidade())) {
                            ProdutoDAO produtoDAO = new ProdutoDAO();
                            produtoDAO.subtrairDoEstoque(cci.getProduto(), cci.getQuantidade());
                        }
                    }
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    request.setAttribute("mensagem", "Compra realizada com sucesso!");  
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("mensagem", "Você não tem permissão para acessar este recurso");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
                requestDispatcher.forward(request, response);
            }
        }

    }
}
