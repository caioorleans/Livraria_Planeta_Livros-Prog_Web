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
                        <button type="button" class="btn btn-outline-light" style="color: blue;" onClick="window.location.href = 'cadastrar_cliente.jsp'"><img
                                src="imgs/login1.png" style="width: 25%;"> Login</button>
                        <button type="button" class="btn btn-outline-light"><img src="imgs/carrinho.png"
                                                                                 style="width: 45%;"></button>
                    </div>
                </div>
            </div>
        </header>

        <!--<form action="Login" method="post">
            <input type="text" name="login" placeholder = "Entre com seu login"/>
            <input type="password" name="senha" placeholder = "Entre com sua senha"/>
            <input type="submit" value="entrar"/>
        </form>

        <% if (request.getAttribute("mensagem") != null) {%>
        <div><%= request.getAttribute("mensagem")%></div>
        <%} %>
        <a href = "cadastrar_cliente.jsp">Cadastre-se</a>
        <hr/>-->

        <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"
                         aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
                    <rect width="100%" height="100%" fill="#777" />
                    </svg>

                    <div class="container">
                        <div class="carousel-caption text-start">
                            <h1>LIVROS</h1>
                            <p></p>

                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="imgs/banner.png" style="width: 50%;">

                    <div class="container">
                        <div class="carousel-caption">
                            <h1>LIVROS</h1>
                            <p></p>
                            <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"
                         aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
                    <rect width="100%" height="100%" fill="#777" />
                    </svg>

                    <div class="container">
                        <div class="carousel-caption text-end">
                            <h1>LIVROS.</h1>
                            <p></p>
                            <p><a class="btn btn-lg btn-primary" href="#"></a></p>
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

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
    </main>


    <script src="js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
    crossorigin="anonymous"></script>
</body>
</html>
