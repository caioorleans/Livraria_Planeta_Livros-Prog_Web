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
        <form action="BuscarProdutoAdm" method="post">
            <div>Descrição:</div>
            <div><input type="text" name="descricao" /></div>
            <div><input type="submit" value="Buscar" /></div>
        </form>
        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%} %>
        <hr/>
        <%
            ArrayList<Produto> produtosDisponiveis = (ArrayList<Produto>) request.getAttribute("produtos");
            if (produtosDisponiveis.isEmpty()) {
        %>
        <div>Nenhum produto encontrado</div>
        <%} else {%>
        <table>
            <%for (int i = 0; i < produtosDisponiveis.size(); i++) {
                    Produto p = produtosDisponiveis.get(i);
            %>
            <tr>
                <td><div><img src="MostrarProdutoFoto?id=<%= p.getId()%>" height="200" /></div></td>
                <td><h4><%=p.getDescricao()%></h4>
                    <h5>R$ <%=p.getPreco()%></h5>
                    <h5>Unidades em estoque: <%=p.getQuantidade()%></h5>
                    <a href ="EditarProduto?produtoId=<%= p.getId()%>">Editar</a>
                    <!--<a href ="AlterarProdutoFoto?produtoId=<%= p.getId()%>">Alterar foto</a>-->
                    <a href ="ExcluirProduto?produtoId=<%= p.getId()%>" method="post" >Excluir</a>
                </td>
            </tr>
            <%}
                }
            %>
        </table>
        <a href="PaginaPrincipalAdm">Voltar</a>
    </body>
</html>
