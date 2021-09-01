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
        <title>Livraria Planeta Livros - Página do Administrador</title>
        
        <style type="text/css"> @import url("css/bootstrap.min.css"); @import url("css/homepage.css")</style>
        
    </head>
    <body>
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
        <% Administrador adm = (Administrador) session.getAttribute("usuario");%>
        <div class="container">
            <div class="row">
                <div class="col">
                    <img src="imgs/cliente.png" class="..." alt="..." style="width: 90%;">
                </div>
                <div class="col">
                    <h1 style="text-align: start;">Olá,<%=adm.getNome()%> </h1>
            
                    <a href = "ListarClientes" class="btn btn-warning btn-lg" style="width: 400px; margin-top: 30px;">Visualizar Clientes</a>
                    <a href = "ListarCategorias" class="btn btn-warning btn-lg" style="width: 400px; margin-top: 30px;">Visualizar Categorias</a>
                    <a href="ListarProdutos" class="btn btn-warning btn-lg" style="width: 400px; margin-top: 30px;">Visualizar Produtos</a>
                    <a href = "VerPerfilAdmServlet" class="btn btn-warning btn-lg" style="width: 400px; margin-top: 30px;">Alterar seus dados</a>
                 
                </div>
                <div class="col">
                    <a href = "LogoutServlet" class="btn btn-outline-danger btn-lg"><img src="imgs/sair.png">Sair</a>
                </div>
            </div>
        </div>
    </body>
</html>
