<%-- 
    Document   : adicionar_nova_categoria
    Created on : 14/08/2021, 17:06:22
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Categoria</title>
    </head>
    <body>
        <h1>Cadastro</h1>
            <form action="AdicionarCategoria" method="post">
                <input type="text" id="descricao" name="descricao" placeholder="Descrição"/>
                <br/>
                <input type="submit" value="cadastrar"/>
            </form>
            <% if (request.getAttribute("mensagem") != null){%>
                <div><%= request.getAttribute("mensagem") %></div>
            <%} %>
    </body>
</html>
