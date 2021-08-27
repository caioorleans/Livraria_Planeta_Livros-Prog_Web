<%-- 
    Document   : atualizar_dados_produto
    Created on : 16/08/2021, 10:52:23
    Author     : caioo
--%>

<%@page import="java.util.List"%>
<%@page import="entidade.categoria.modelo.Categoria"%>
<%@page import="entidade.categoria.modelo.Categoria"%>
<%@page import="entidade.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AtualizarProduto" method="POST">
            <%Produto p = (Produto) request.getAttribute("produto");%>
            <input type="hidden" name="id" value=<%=p.getId()%>>
            <tr>
                <td>Descrição:</td>
                <td><input type="text" id="descricao" name="descricao" value ="<%=p.getDescricao()%>" ></td>
                <td>Preço:</td>
                <td><input type="text" id="preco" name="preco" value ="<%=p.getPreco()%>" ></td>
                <td>Quantidade:</td>
                <td><input type="text" id="quantidade" name="quantidade" value ="<%=p.getQuantidade()%>" ></td>
            </tr>
            <input type="submit">
        </form>

        <table>
            <tr>
                <td>
                    <h2>Produto e suas Categorias</h2>
                    <%
                        List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                        if (categorias != null && categorias.size() > 0) {
                    %>
                    <div>Adicionar nova Categoria:</div>
                    <jsp:useBean id="produto" class="entidade.produto.modelo.Produto" scope="request" />
                    <div>
                        <form action="InserirCategoriaProduto" method="post">
                            <input type="hidden" name="produtoId" value="<jsp:getProperty name="produto" property="id" />" />
                            <select name="categoriaId">
                                <%
                                    for (Categoria categoria : categorias) {
                                %>
                                <option value="<%= categoria.getId()%>"><%= categoria.getDescricao()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <input type="submit" value="Adicionar" />
                        </form>
                    </div>
                    <%
                        }
                    %>
                    <%
                        if (p.getCategorias().size() > 0) {
                    %>
                    <div>Categorias Vinculadas:</div>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Descrição</th>
                            <th></th>
                        </tr>
                        <%
                            for (Categoria categoria : p.getCategorias()) {
                        %>
                        <tr>
                            <td><%= categoria.getId()%></td>
                            <td><%= categoria.getDescricao()%></td>
                            <td><a href="ExcluirCategoriaProduto?produtoId=<%= p.getId()%>&categoriaId=<%= categoria.getId()%>">Excluir</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <%
                        }
                    %>
                </td>
                <td>
                    <%if (p.getFoto() != null) {%>
                    <div><img src="MostrarProdutoFoto?id=<%= p.getId()%>" height="200" /></div>
                        <%}%>
                    <form method="post" enctype="multipart/form-data" action="UploadProdutoFoto">
                        <input type="hidden" name="id" value="<%= p.getId()%>" />
                        <input type="file" name="foto" placeholder="Selecione uma foto" />
                        <br/>
                        <input type="submit" value="Atualizar" />
                    </form>
                </td>
            </tr>
        </table>
        <a href="ListarProdutos">Voltar ao menu de produtos</a>
    </body>
</html>
