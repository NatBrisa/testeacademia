/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function loadBusca(nome, rg, cpf, tipo) {
    var requestURL = "http://localhost:8080/v1/" + tipo;
    alert(requestURL);
    var request = new XMLHttpRequest();
    request.open("GET", requestURL);
    alert(request);
    request.responseType = 'json';
    request.send();
    return request.response;
}

var nResults;

function loadBuscaSemBD() {
    
    //teste sem BD
    
    var p1 = {
        nome: "pessoa1", 
        rg: "0000", 
        cpf: "1111"
    };
    
    var p2 = {
        nome: "pessoa2", 
        rg: "2222", 
        cpf: "3333"
    };

    window.console.log("P1: " + p1.nome + "     /     P2: " + p2.nome);
    var resultados = new Array(p1, p2); 
    for(var i=0;i<resultados.length;i++){
        window.console.log("Array Resultado: " + resultados[i].nome);
    }
    
    
    return resultados;
}


