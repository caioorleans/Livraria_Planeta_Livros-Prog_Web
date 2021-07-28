function validationRegister() {
    var name = document.getElementById("nome");
    var address = document.getElementById("endereco");
    var emaill = document.getElementById("email");
    var login = document.getElementById("login");
    var password = document.getElementById("senha");

    if (validarCaractereValido(name) && validarCaractereValido(address) && validarEmail(emaill) && validarCaractereValido(login) && validarTamanho(password, 5)) {
        return true;
    } else {
        return false;
    }

}

function validarNaoVazio(elemento) {

    if (elemento == null) {
        alert("O elemento de busca não existe");
        return false;
    }
    if (elemento.value == null || elemento.value.length == 0) {
        alert("Preencha o " + elemento.name);
        return false;
    }
    return true;
}

function validarCaractereValido(elemento) {
    if (validarNaoVazio(elemento)) {
        if (/^\s+$/.test(elemento.value)) {
            alert("Preencha " + elemento.name + " com caracteres válidos");
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}

function validarEmail(elemento) {
    if (validarCaractereValido(elemento)) {
        usuario = elemento.value.substring(0, elemento.value.indexOf("@"));
        dominio = elemento.value.substring(elemento.value.indexOf("@") + 1, elemento.value.length);
        if ((usuario.length >= 1) &&
                (dominio.length >= 3) &&
                (usuario.search("@") == -1) &&
                (dominio.search("@") == -1) &&
                (usuario.search(" ") == -1) &&
                (dominio.search(" ") == -1) &&
                (dominio.search(".") != -1) &&
                (dominio.indexOf(".") >= 1) &&
                (dominio.lastIndexOf(".") < dominio.length - 1)) {
            return true;
        } else {
            alert("E-mail invalido");
            return false;
        }
    }
    else{
        return false;
    }
}

function validarTamanho(elemento, tamanho) {
    if (validarCaractereValido(elemento)) {
        if (elemento.value.length < tamanho) {
            alert(elemento.name + " deve ter menos " + tamanho + " caracteres validos.");
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}