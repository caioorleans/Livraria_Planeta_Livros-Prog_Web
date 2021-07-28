<%-- 
    Document   : perfil_adm
    Created on : 24/07/2021, 16:22:57
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria Orleanz - Perfil</title>
    </head>
    <body>
        <h1>Perfil do Administrador</h1>
        <jsp:useBean id="usuario" class="entidade.administrador.modelo.Administrador" scope="session"/>
        <table>
            <tr>
                <td>Nome:</td>
                <td><jsp:getProperty name="usuario" property="nome"/></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><jsp:getProperty name="usuario" property="email"/></td>
            </tr>
            <tr>
                <td>Login:</td>
                <td><jsp:getProperty name="usuario" property="login"/></td>
            </tr>
            <tr>    
                <td>Senha:</td>
                <td><jsp:getProperty name="usuario" property="senha"/></td>
            </tr>
        </table>
    </body>
</html>
