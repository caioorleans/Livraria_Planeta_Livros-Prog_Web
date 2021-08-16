<%-- 
    Document   : atualizar_foto_produto
    Created on : 15/08/2021, 21:47:36
    Author     : caioo
--%>

<%@page import="entidade.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atualizar Foto do Produto</h1>
        <%
            Produto produto = (Produto) request.getAttribute("produto");
            if (produto != null) {
        %>
        <form method="post" enctype="multipart/form-data" action="UploadProdutoFoto">
            <input type="hidden" name="id" value="<%= produto.getId() %>" />
            <input type="file" name="foto" placeholder="Selecione uma foto" />
            <br/>
            <input type="submit" value="Atualizar" />
        </form>
        <%
            }
            if (request.getAttribute("mensagem") != null) {
        %>
        <div><%= request.getAttribute("mensagem") %></div>
        <%
            }
        %>
    </body>
</html>
