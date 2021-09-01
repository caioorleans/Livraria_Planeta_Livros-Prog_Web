<%-- 
    Document   : listagem_de_categorias
    Created on : 14/08/2021, 15:12:27
    Author     : caioo
--%>

<%@page import="entidade.categoria.modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <h1>Menu de Categorias</h1>
        <a href="NovaCategoria">Adicionar nova categoria</a>
        <form action="BuscarCategoriaAdm" method="post">
            <div>Descrição:</div>
            <div><input type="text" name="descricao" /></div>
            <div><input type="submit" value="Buscar" /></div>
        </form>
        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%} %>
        <hr/>
        <%
            ArrayList<Categoria> produtosDisponiveis = (ArrayList<Categoria>) request.getAttribute("categorias");
            if (produtosDisponiveis.isEmpty()) {
        %>
        <div>Não existem produtos disponíveis</div>
        <%} else {
            for (int i = 0; i < produtosDisponiveis.size(); i++) {
                Categoria c = produtosDisponiveis.get(i);
        %>
        <div>
            <h4><%=c.getDescricao()%></h4>
            <a href ="EditarCategoria?categoriaId=<%= c.getId()%>" method="post">Editar</a>
            <a href ="ExcluirCategoria?categoriaId=<%= c.getId()%>" method="post">Excluir</a>
        </div>
        <%}
            }
        %>
        <a href="PaginaPrincipalAdm">Voltar</a>
    </body>
</html>
