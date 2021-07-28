<%-- 
    Document   : index
    Created on : 23/07/2021, 18:25:14
    Author     : caioo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livraria Orleans</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div class="img-slider">
        <nav>
            <input type="checkbox" id="check">
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>
            <label class="logo">Minha Logo</label>
            <ul>
                <li><a class="active" href="#">Início</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href = "cadastrar_cliente.jsp">Cadastre-se</a></li>
                <li><form action="Login" method="post">
                        <input type="text" name="login" placeholder = "Entre com seu login"/>
                        <input type="password" name="senha" placeholder = "Entre com sua senha"/>
                        <% if (request.getAttribute("mensagem") != null){%>
                            <div style = "display:block; font-size: 10px; "><%= request.getAttribute("mensagem") %></div>
                        <%} %>
                        <input type="submit" value="entrar"/>
                    </form>
                </li>
            </ul>
        </nav>

        <div class="slide active">
            <img src="imagens/22.png" alt="">
            <div class="info">
                <h2>Slide 01</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
        </div>
        <div class="slide">
            <img src="imagens/33.png" alt="">
            <div class="info">
                <h2>Slide 02</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
        </div>
        <div class="slide">
            <img src="imagens/66.png" alt="">
            <div class="info">
                <h2>Slide 03</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
        </div>
        <div class="slide">
            <img src="imagens/44.png" alt="">
            <div class="info">
                <h2>Slide 04</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
        </div>
        <div class="slide">
            <img src="imagens/55.png" alt="">
            <div class="info">
                <h2>Slide 05</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
        </div>
        <div class="navigation">
            <div class="btn active"></div>
            <div class="btn"></div>
            <div class="btn"></div>
            <div class="btn"></div>
            <div class="btn"></div>
        </div>
        <a class="butao" href="#"><img src="imagens/77.png" alt=""></a>
        <div class="Cat">
            <h1>Categorias em Destaque</h1>
            <div class="categorias">
                <ul>
                    <li><img src="imagens/teste2.jpg" alt=""></li>
                    <li class="tentativa2"><img src="imagens/teste.jpg" alt=""></li>
                    <li class="tentativa3"><img src="imagens/teste4.jpg" alt=""></li>
                    <li class="tentativa4"><img src="imagens/teste5.jpg" alt=""></li>
                    <li class="tentativa5"><img src="imagens/teste6.jpg" alt=""></li>
                    <li class="tentativa6"><img src="imagens/teste7.jpg" alt=""></li>

                </ul>
            </div>
            <div class="Cat2">
                <h1>Novidades Para Você</h1>
                <div class="categorias">
                    <ul>
                        <li><img src="imagens/teste2.jpg" alt=""></li>
                        <li class="tentativa2"><img src="imagens/teste.jpg" alt=""></li>
                        <li class="tentativa3"><img src="imagens/teste4.jpg" alt=""></li>
                        <li class="tentativa4"><img src="imagens/teste5.jpg" alt=""></li>
                        <li class="tentativa5"><img src="imagens/teste6.jpg" alt=""></li>
                        <li class="tentativa6"><img src="imagens/teste7.jpg" alt=""></li>

                    </ul>
                </div>
            </div>

        </div>


        <script type="text/javascript">
            var slides = document.querySelectorAll('.slide');
            var btns = document.querySelectorAll('.btn');
            let currentSlide = 1;

            // Javascript for image slider manual navigation
            var manualNav = function(manual) {
                slides.forEach((slide) => {
                    slide.classList.remove('active');

                    btns.forEach((btn) => {
                        btn.classList.remove('active');
                    });
                });

                slides[manual].classList.add('active');
                btns[manual].classList.add('active');
            }

            btns.forEach((btn, i) => {
                btn.addEventListener("click", () => {
                    manualNav(i);
                    currentSlide = i;
                });
            });

            // Javascript for image slider autoplay navigation
            var repeat = function(activeClass) {
                let active = document.getElementsByClassName('active');
                let i = 1;

                var repeater = () => {
                    setTimeout(function() {
                        [...active].forEach((activeSlide) => {
                            activeSlide.classList.remove('active');
                        });

                        slides[i].classList.add('active');
                        btns[i].classList.add('active');
                        i++;

                        if (slides.length == i) {
                            i = 0;
                        }
                        if (i >= slides.length) {
                            return;
                        }
                        repeater();
                    }, 10000);
                }
                repeater();
            }
            repeat();
        </script>


</body>
</html>
