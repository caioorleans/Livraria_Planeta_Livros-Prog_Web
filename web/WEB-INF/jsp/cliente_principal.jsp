<%-- 
    Document   : cliente_principal
    Created on : 23/07/2021, 19:30:35
    Author     : caioo
--%>

<%@page import="entidade.cliente.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria Orleanz - Página Inicial</title>
    </head>
    <body>
        <% Cliente cliente = (Cliente)session.getAttribute("usuario"); %>
        <h1>Olá,<%=cliente.getNome() %> </h1>
        <a href = "VerPerfilServlet">Ver perfil</a>
        <a href = "LogoutServlet">Sair</a>
    </body>
</html>
