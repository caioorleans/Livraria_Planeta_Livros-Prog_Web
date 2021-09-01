<%-- 
    Document   : ver_cliente_compras
    Created on : 01/09/2021, 12:56:36
    Author     : caioo
--%>

<%@page import="entidade.compra.modelo.Compra"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Compras do cliente</h1>
        <hr>
        <%ArrayList<Compra> compras = (ArrayList<Compra>) request.getAttribute("compras");
        if(compras.isEmpty()){%>
        <p>O cliente não realizou nenhuma compra!</p>
        <%}else{
        for(int i = 0; i < compras.size(); i++){%>
            <h2>Data da compra: <%=compras.get(i).getDataHora()%></h2>
            <table>
                <tr>
                    <%for(int j = 0; j < compras.get(i).getProdutos().size(); j++){%>
                    <td>
                        <img src="MostrarProdutoFoto?id=<%=compras.get(i).getProdutos().get(j).getId()%>">
                        <h3>Produto: <%=compras.get(i).getProdutos().get(j).getDescricao()%></h3>
                        <h3>Preço: <%=compras.get(i).getProdutos().get(j).getPreco()%></h3>
                        <p>Quantidade: <%=compras.get(i).getProdutos().get(j).getQuantidade()%></p>
                    </td>
                    <%}%>
                </tr>
            </table>
                <a href="CancelarCompra?idCompra=<%=compras.get(i).getId()%>">Cancelar compra</a>
            <hr>
        <%}}%>
    </body>
</html>
