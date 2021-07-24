<%-- 
    Document   : adm_principal
    Created on : 24/07/2021, 16:15:14
    Author     : caioo
--%>

<%@page import="entidade.administrador.modelo.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria Orleanz - Página Administrador</title>
    </head>
    <body>
        <% Administrador adm = (Administrador)session.getAttribute("usuario"); %>
        <h1>Olá,<%=adm.getNome() %> </h1>
        <a href = "VerPerfilServlet">Ver perfil</a>
        <a href = "LogoutServlet">Sair</a>
    </body>
</html>
