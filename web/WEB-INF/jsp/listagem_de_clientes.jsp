<%-- 
    Document   : listagem_de_clientes
    Created on : 14/08/2021, 14:08:09
    Author     : caioo
--%>

<%@page import="entidade.cliente.modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu de Produtos</h1>
        <a href="NovoProduto">Adicionar novo Produto</a>
        <form action="BuscarProdutoAdm" method="post">
            <div>Descrição:</div>
            <div><input type="text" name="descricao" /></div>
            <div><input type="submit" value="Buscar" /></div>
        </form>
        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%} %>
        <hr/>
        <%
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("clientes");
            if (clientes.isEmpty()) {
        %>
        <div>Nenhum produto encontrado</div>
        <%} else {%>
            <%for (int i = 0; i < clientes.size(); i++) {
                    Cliente c = clientes.get(i);
            %>
            <h4>Nome: <%=c.getNome()%></h4>
            <h5>Identificador: <%=c.getId()%></h5>
            <h5>Endereço: <%=c.getEndereco()%></h5>
            <a href="VerComprasClienteAdm?idCliente=<%=c.getId()%>">Ver compras do cliente</a>
            <hr>
            <%}
                }
            %>
        <a href="PaginaPrincipalAdm">Voltar</a>
    </body>
</html>
