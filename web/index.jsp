<%-- 
    Document   : index
    Created on : 23/07/2021, 18:25:14
    Author     : caioo
--%>

<%@page import="java.util.List"%>
<%@page import="entidade.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livraria Orleans</title>
</head>

<body>
    
    <form action="Login" method="post">
        <input type="text" name="login" placeholder = "Entre com seu login"/>
        <input type="password" name="senha" placeholder = "Entre com sua senha"/>
        <input type="submit" value="entrar"/>
    </form>
    
    <% if (request.getAttribute("mensagem") != null) {%>
    <div><%= request.getAttribute("mensagem")%></div>
    <%} %>
    <a href = "cadastrar_cliente.jsp">Cadastre-se</a>
    <hr/>
    
    <h1>Novidades Para Você</h1>
    <hr/>
    <%
        List<Produto> produtosDisponiveis = (List<Produto>) request.getAttribute("produtosDisponiveis");
        if (produtosDisponiveis.isEmpty()) {
    %>
    <div>Não existem produtos disponíveis</div>
    <%} else {
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            Produto p = produtosDisponiveis.get(i);
    %>
    <div>
        <h4><%=p.getDescricao()%></h4>
        <h5><%=p.getPreco()%></h5>
    </div>
    <%}
        }
    %>
</body>
</html>
