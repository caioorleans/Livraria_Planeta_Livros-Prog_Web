function validationRegister(){
    var name = document.getElementById("nome");
    var address = document.getElementById("endereco");
    var emaill = document.getElementById("email");
    var login = document.getElementById("login");
    var password = document.getElementById("senha");
    
    if(validarCaractereValido(name) && validarCaractereValido(address) && validarCaractereValido(emaill) && validarCaractereValido(login) && validarTamanho(password,5)){
        return true;
    }
    else{
        return false;
    }
     
}

function validarNaoVazio(elemento){
    
    if (elemento == null){
        alert("O elemento de busca não existe");
        return false;
    }
    if (elemento.value == null || elemento.value.length == 0) {
        alert("Preencha o " + elemento.name);
        return false;
    }
    return true;
}

function validarCaractereValido(elemento){
    if(validarNaoVazio(elemento)){
        if(/^\s+$/.test(elemento.value)){
            alert("Preencha " + elemento.name + " com caracteres válidos");
            return false;
        }
        else{
            return true;
        }
    }
    else{
        return false;
    }
}
function validarTamanho(elemento, tamanho){
    if(validarCaractereValido(elemento)){
        if( elemento.value.length < tamanho){
            alert(elemento.name + " deve ter menos " + tamanho + " caracteres validos.");
            return false;
        }
        else{
            return true;
        }
    }
    else{
        return false;
    }
}