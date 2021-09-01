<%-- 
    Document   : index
    Created on : 23/07/2021, 18:25:14
    Author     : caioo
--%>

<%@page import="entidade.cliente.modelo.Cliente"%>
<%@page import="entidade.carrinhocompra.modelo.CarrinhoCompraItem"%>
<%@page import="java.util.List"%>
<%@page import="entidade.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.87.0">
    <title>Livraria Planeta Livros </title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">

    <link href="css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/homepage.css" rel="stylesheet">
</head>

<body>
    <main>
        <header class="p-3 bg-light text-white">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <div class="float-start"><a class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"
                                                href="Inicio"><img src="imgs/logop.png" style="width: 50%;"></a>
                    </div>

                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" id="search">
                        <input type="search" class="rounded form-control form-control-dark" placeholder="Search..."
                               aria-label="Search">
                    </form>
                    
                    <div class="d-grid gap-2 d-md-flex text-end justify-content-md-end float-end">
                        <% Cliente cliente = (Cliente)session.getAttribute("usuario"); 
                        if(cliente == null){%>
                        <button type="button" class="btn btn-outline-light" style="color: blue;" onClick="window.location.href = 'cadastrar_cliente.jsp'">
                            <img src="imgs/login1.png" style="width: 25%;"> Login</button>
                        <%}else{%>
                        <form method="post" action="Login">
                            <input type="hidden" name="login" value="<%=cliente.getLogin()%>">
                            <input type="hidden" name="senha" value="<%=cliente.getSenha()%>">
                            <input type="submit" class="btn btn-outline-light" style="color: blue;" value="Ver Perfil">
                        </form>
                            
                        <%}%>
                        <button type="button" class="btn btn-outline-light"><img src="imgs/carrinho.png" style="width: 45%;"></button>
                    </div>
                </div>
            </div>
        </header>

        <!--<form action="Login" method="post">
            <input type="text" name="login" placeholder = "Entre com seu login"/>
            <input type="password" name="senha" placeholder = "Entre com sua senha"/>
            <input type="submit" value="entrar"/>-->
        </form>

        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%} %>
        <!--<a href = "cadastrar_cliente.jsp">Cadastre-se</a>
        <hr/>-->

        <h1>Novidades Para Você</h1>
        <hr/>
        <%
            List<Produto> produtosDisponiveis = (List<Produto>) request.getAttribute("produtosDisponiveis");
            if (produtosDisponiveis.isEmpty()) {
        %>
        <div>Não existem produtos disponíveis</div>
        <%} else {%>
        <table>
            <tr>
                <%for (int i = 0; i < produtosDisponiveis.size(); i++) {
                        Produto p = produtosDisponiveis.get(i);
                %>
                <td>
                    <div class="card mb-3" style="max-width: 540px;">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="MostrarProdutoFoto?id=<%= p.getId()%>" class="img-fluid rounded-start" alt="..." >
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title"><%=p.getDescricao()%></h5>
                                    <p class="card-text"><small class="text-muted">R$ <%=p.getPreco()%></small></p>
                                    <a href="AdicionarProdutoCarrinhoCompra?produtoId=<%= p.getId()%>">Adicionar ao Carrinho de Compras</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <%}%>
            </tr>
        </table>
        <%}
        %>
        <h1>Carrinho de Compras</h1>
        <%
            List<CarrinhoCompraItem> carrinhoCompraItens = (List<CarrinhoCompraItem>) request.getAttribute("carrinhoCompraItens");
            double total = 0;
            if (carrinhoCompraItens == null || carrinhoCompraItens.isEmpty()) {
        %>
        <div>Não existem itens no seu carrinho de compras</div>
        <%
        } else {

            for (int i = 0; i < carrinhoCompraItens.size(); i++) {
                CarrinhoCompraItem cci = carrinhoCompraItens.get(i);
                total += cci.getQuantidade() * cci.getProduto().getPreco();
        %>
        <div>
            <h4><%= cci.getProduto().getDescricao()%></h4>
            <h5>Preço: <%= cci.getProduto().getPreco()%></h5>
            <h6>Quantidade: <%= cci.getQuantidade()%></h6>
            <div><a href="RemoverProdutoCarrinhoCompra?produtoId=<%= cci.getProduto().getId()%>">Remover do Carrinho de Compras</a></div>
        </div>
            <%}%>
            <div>Total: R$ <%= total%></div>
            <a href="EfetivarCompra">Finalizar compra</a>
        <%}
        %>
    </main>


    <script src="js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
    crossorigin="anonymous"></script>
</body>
</html>
