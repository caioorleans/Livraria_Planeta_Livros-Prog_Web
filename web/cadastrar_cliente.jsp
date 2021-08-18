<%-- 
    Document   : cadastrar_cliente
    Created on : 23/07/2021, 19:59:49
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro ou login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="script/register.js"></script>
    </head>
    <body>

        <div class="back">
            <button class="btnBack" onClick="window.location.href = 'Inicio'">Voltar</button>
        </div> 
        <div class="container">      
            <div class="blueBg">
                <div class="box signin">
                    <h2>Já tem uma conta?</h2>
                    <button class="signinBtn">Login</button>
                </div>
                <div class="box signup">
                    <h2>Ainda não tem uma conta?</h2>
                    <button class="signupBtn">Cadastre-se</button>
                </div>
            </div>
            <div class="formBx">
                <div class="form signinForm">
                    <form action="Login" method="post">
                        <h3>Faça seu login</h3>
                        <input type="text" name="login" placeholder="Login">
                        <input type="password" name="senha" placeholder="Senha">
                        <input type="submit" value="Entrar">
                    </form>
                </div>

                <div class="form signupForm">
                    <form action="CadastrarClienteServlet" method="post" onSubmit="return validationRegister(event);">
                        <h3>Cadastre-se</h3>
                        <input type="text" id="nome" name="nome" placeholder="Nome">
                        <input type="text" id="endereco" name="endereco" placeholder="Endereço">
                        <input type="text" id="email" name="email" placeholder="E-mail">
                        <input type="text" id="login" name="login" placeholder="Login">
                        <input type="password" id="senha" name="senha" placeholder="Senha">
                        <input type="submit" value="Cadastrar">
                    </form>
                    <% if (request.getAttribute("mensagem") != null) {%>
                    <div><%= request.getAttribute("mensagem")%></div>
                    <%}%>
                </div>

            </div>  
        </div>

        <script>
            const signinBtn = document.querySelector('.signinBtn');
            const signupBtn = document.querySelector('.signupBtn');
            const btnBack = document.querySelector('.btnBack');
            const formBx = document.querySelector('.formBx');
            const body = document.querySelector('body');

            signupBtn.onclick = function () {
                formBx.classList.add('active')
                body.classList.add('active')
            }

            signinBtn.onclick = function () {
                formBx.classList.remove('active')
                body.classList.remove('active')
            }

            btnBack.onclick = function () {
                //voltar pra home
            }
        </script>

        <!--<div class="login-page">
            <div class="form">
                <a id="btnback" href="Inicio"><img src="imagens/back.png" /></a>

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
                <% if (request.getAttribute("mensagem") != null) {%>
                <div><%= request.getAttribute("mensagem")%></div>
                <%}%>
            </div>
        </div>-->
    </body>
</html>
