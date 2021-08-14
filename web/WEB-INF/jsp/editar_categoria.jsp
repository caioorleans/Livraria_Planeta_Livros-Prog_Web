<%-- 
    Document   : editar_categoria
    Created on : 14/08/2021, 15:58:13
    Author     : caioo
--%>

<%@page import="entidade.categoria.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RealizarUpdateCategoria" method="POST">
            <%Categoria c = (Categoria)request.getAttribute("categoria");%>
            <input type="hidden" name="id" value=<%=c.getId()%>>
            <tr>
                <td>Descrição:</td>
                <td><input type="text" id="descricao" name="descricao" value =<%=c.getDescricao()%> ></td>
            </tr>
            <input type="submit">
        </form>
    </body>
</html>
