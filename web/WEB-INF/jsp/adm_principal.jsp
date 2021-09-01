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
        <% Administrador adm = (Administrador) session.getAttribute("usuario");%>
        <div class="container">
            <div class="row">
                <div class="col">
                    <img src="imgs/cliente.png" class="..." alt="..." style="width: 90%;">
                </div>
                <div class="col">
                    <h1 style="text-align: start;">Olá,<%=adm.getNome()%> </h1>
            
                    <a href = "IrRelatorios" class="btn btn-warning btn-lg" style="width: 400px; margin-top: 30px;">Relatórios Gerenciais</a>
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
