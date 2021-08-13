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
        <script src="../../scripts/register.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Perfil do Administrador</h1>
        <jsp:useBean id="usuario" class="entidade.administrador.modelo.Administrador" scope="session"/>
        <form action="AlterarPerfilAdm" method="post" onSubmit="return validationRegister(event);">
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" id="nome" name="nome" placeholder="Nome" value = <jsp:getProperty name="usuario" property="nome"/>></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" id="email" name="email" placeholder="E-mail" value = <jsp:getProperty name="usuario" property="email"/>></td>
                </tr>
                <tr>
                    <td>Login:</td>
                    <td><input type="text" id="login" name="login" placeholder="Login" value = <jsp:getProperty name="usuario" property="login"/>></td>
                </tr>
                <tr>    
                    <td>Senha:</td>
                    <td><input type="text" id="senha" name="senha" placeholder="Senha" value = <jsp:getProperty name="usuario" property="senha"/>></td>
                </tr>
            </table>
            <input type="submit" value="cadastrar"/>
        </form>
        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%}%>
        <a href = "ExcluirPerfilAdm">Excluir perfil</a>
    </body>
</html>
