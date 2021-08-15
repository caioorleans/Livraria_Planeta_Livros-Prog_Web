<%-- 
    Document   : listagem_de_produtos
    Created on : 15/08/2021, 14:57:05
    Author     : caioo
--%>

<%@page import="entidade.produto.modelo.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu de Produtos</h1>
        <a href="NovoProduto">Adicionar novo Produto</a>
        <h2>Produtos disponíveis</h2>
        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%} %>
        <hr/>
        <%
            ArrayList<Produto> produtosDisponiveis = (ArrayList<Produto>) request.getAttribute("produtos");
            if (produtosDisponiveis.isEmpty()) {
        %>
        <div>Não existem produtos disponíveis</div>
        <%} else {
            for (int i = 0; i < produtosDisponiveis.size(); i++) {
                Produto p = produtosDisponiveis.get(i);
        %>
        <div>
            <h4><%=p.getDescricao()%></h4>
            <h5>R$ <%=p.getPreco()%></h5>
            <h5>Unidades em estoque: <%=p.getQuantidade()%></h5>
            <a href ="EditarCategoria?produtoId=<%= p.getId()%>">Editar</a>
            <a href ="ExcluirCategoria?produtoId=<%= p.getId()%>" method="post" >Excluir</a>
        </div>
        <%}
            }
        %>
        <a href="PaginaPrincipalAdm">Voltar</a>
    </body>
</html>
