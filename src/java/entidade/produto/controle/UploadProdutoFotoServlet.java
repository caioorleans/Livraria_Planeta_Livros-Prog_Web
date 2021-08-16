/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.produto.controle;

import entidade.produto.modelo.ProdutoDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author caioo
 */
public class UploadProdutoFotoServlet extends HttpServlet {

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
        int id = -1;
        FileItem foto = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            boolean sucesso = false;
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(new File("C:/Users/caioo/Documents/NetBeansProjects/Livraria_Planeta_Livros-Prog_Web/temp"));

                ServletFileUpload upload = new ServletFileUpload(factory);

                List<FileItem> itens = upload.parseRequest(new ServletRequestContext(request));
                Iterator<FileItem> iter = itens.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    
                    if (!item.isFormField() && item.getFieldName().equals("foto")) {
                        foto = item;
                    }
                    
                    if (item.isFormField() && item.getFieldName().equals("id")) {
                        id = Integer.parseInt(item.getString());
                    }
                }
                
                if (id != -1 && foto != null) {
                    foto.write(new File("C:/Users/caioo/Documents/NetBeansProjects/Livraria_Planeta_Livros-Prog_Web/produtos/" + id + foto.getName().substring(foto.getName().lastIndexOf("."))));
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.atualizarFoto(id, "C:/Users/caioo/Documents/NetBeansProjects/Livraria_Planeta_Livros-Prog_Web/produtos/" + id + foto.getName().substring(foto.getName().lastIndexOf(".")));
                    sucesso = true;
                }
                
                if (sucesso) {
                    request.setAttribute("mensagem", "Upload da foto deste produto foi efetuado com sucesso");
                } else {
                    request.setAttribute("mensagem", "Não foi possível processo o upload da foto deste produto");
                }
            } catch (Exception ex) {
                request.setAttribute("mensagem", "Não foi possível processo o upload da foto deste produto");
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProdutos");
        requestDispatcher.forward(request, response);
    }
}
