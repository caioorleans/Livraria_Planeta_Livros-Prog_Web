<%-- 
    Document   : index
    Created on : 23/07/2021, 18:25:14
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria Orleanz - Página Inicial</title>
    </head>
    <body>
        <h1>Identificação do Usuário</h1>
        <form action="LoginServlet" method="post">
            <input type="text" name="login" placeholder = "Entre com seu login de usuário"/>
            <br/>
            <input type="password" name="senha" placeholder = "Entre com sua senha de usuário"/>
            <br/>
            <input type="submit" value="entrar"/>
        </form>
        <div><a href = "cadastrar_cliente.jsp">Cadastre-se aqui</a></div>
        <% if (request.getAttribute("mensagem") != null){%>
            <div><%= request.getAttribute("mensagem") %></div>
        <%} %>
    </body>
</html>
