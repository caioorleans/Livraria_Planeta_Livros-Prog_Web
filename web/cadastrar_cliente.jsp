<%-- 
    Document   : cadastrar_cliente
    Created on : 23/07/2021, 19:59:49
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria Orleanz - Cadastro</title>
    </head>
    <body>
        <h1>Cadastro</h1>
        <form action = "CadastrarClienteServlet" method="post">
            <input type="text" name="nome" placeholder = "Nome"/>
            <br/>
            <input type="text" name="endereco" placeholder = "Endereço"/>
            <br/>
            <input type="text" name="email" placeholder = "E-mail"/>
            <br/>
            <input type="text" name="login" placeholder = "Login"/>
            <br/>
            <input type="password" name="senha" placeholder = "Senha"/>
            <br/>
            <input type="submit" value="cadastrar">
        </form>
        <% if (request.getAttribute("mensagem") != null){%>
            <div><%= request.getAttribute("mensagem") %></div>
        <%} %>
    </body>
</html>