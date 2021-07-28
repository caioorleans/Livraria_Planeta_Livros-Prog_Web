<%-- 
    Document   : cadastrar_cliente
    Created on : 23/07/2021, 19:59:49
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livraria Orleanz - Cadastro</title>
        <link rel="stylesheet" href="css/style2.css">
        <script type="text/javascript" src="scripts/register.js"></script>
    </head>
    <body>
    <div class="login-page">
        <div class="form">
            <a id="btnback" href="index.jsp"><img src="imagens/back.png" /></a>

            <h1>Cadastro</h1>
            <form action="CadastrarClienteServlet" method="post" onSubmit="return validationRegister(event);">
                <input type="text" id="nome" name="nome" placeholder="Nome"/>
                <br/>
                <input type="text" id="endereco" name="endereco" placeholder="Endereço"/>
                <br/>
                <input type="text" id="email" name="email" placeholder="E-mail"/>
                <br/>
                <input type="text" id="login" name="login" placeholder="Login"/>
                <br/>
                <input type="password" id="senha" name="senha" placeholder="Senha"/>
                <br/>
                <input type="submit" value="cadastrar"/>
            </form>
            <% if (request.getAttribute("mensagem") != null){%>
                <div><%= request.getAttribute("mensagem") %></div>
            <%} %>
        </div>
    </div>
    <script type="text/javascript">
        $('.message a').click(function() {
            $('form').animate({
                height: "toggle",
                opacity: "toggle"
            }, "slow");
        });
    </script>
    
</body>
</html>
