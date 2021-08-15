<%-- 
    Document   : adicionar_novo_produto
    Created on : 15/08/2021, 16:00:45
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AdicionarProduto" method="post">
            <input type="text" id="descricao" name="descricao" placeholder="Descrição"/>
            <br/>
            <input type="text" id="preco" name="preco" placeholder="Preço"/>
            <br/>
            <input type="text" id="quantidade" name="quantidade" placeholder="Quantidade"/>
            <br/>
            <input type="submit" value="cadastrar"/>
        </form>
        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%}%>
    </body>
</html>
