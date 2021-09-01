/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios.controle;

import entidade.produto.modelo.Produto;
import entidade.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caioo
 */
public class RelatorioProdutosIndisponiveisServlet extends HttpServlet {

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
        List<Produto> resultado = null;

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        resultado = produtoDAO.recuperarProdutosEmFalta();
        boolean sucesso = (resultado != null);

        if (sucesso) {
            response.setContentType("text/plain;charset=UTF-8");
            response.setHeader("Content-disposition", "attachment; filename=relatorio2.txt");
            try (PrintWriter out = response.getWriter()) {
                out.println("RELATÓRIO 2 - PRODUTOS INDISPONÍVEIS NO ESTOQUE");
                if (resultado.isEmpty()) {
                    out.println("A CONSULTA NÃO GEROU RESULTADOS");
                } else {
                    out.println("ID" + "\t" + "DESCRIÇÃO" + "\t" + "PREÇO");
                    for (Produto r : resultado) {
                        out.println(r.getId() + "\t" + r.getDescricao()+ "\t" + numberFormat.format(r.getPreco()));
                    }
                }
            }
        } else {
            request.setAttribute("mensagem", "Problemas ao gerar o relatório");
            RequestDispatcher dispatcher = request.getRequestDispatcher("");
            dispatcher.forward(request, response);
        }
    }
}
