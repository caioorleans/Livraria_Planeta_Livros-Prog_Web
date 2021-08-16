<%-- 
    Document   : atualizar_dados_produto
    Created on : 16/08/2021, 10:52:23
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
        <form action="AtualizarProduto" method="POST">
            <%Produto p = (Produto)request.getAttribute("produto");%>
            <input type="hidden" name="id" value=<%=p.getId()%>>
            <tr>
                <td>Descrição:</td>
                <td><input type="text" id="descricao" name="descricao" value =<%=p.getDescricao()%> ></td>
                <td>Preço:</td>
                <td><input type="text" id="preco" name="preco" value =<%=p.getPreco()%> ></td>
                <td>Quantidade:</td>
                <td><input type="text" id="quantidade" name="quantidade" value =<%=p.getQuantidade()%> ></td>
            </tr>
            <input type="submit">
        </form>
    </body>
</html>
