/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function inputTestNome() {
    var nome = prompt("Nome: ");
    return nome;
}

function inputTestRg() {
    var rg = prompt("RG: ");
    return rg;
}

function inputTestCpf() {
    var cpf = prompt("CPF: ");
    return cpf;
}

function inputTest() {
    var input = prompt("Input: ");
    return input;
}

function pessoa(nome, rg, cpf) {
    this.nome = nome;
    this.rg = rg;
    this.cpf =cpf;
}