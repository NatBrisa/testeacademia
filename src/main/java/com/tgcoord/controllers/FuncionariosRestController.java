/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.service.ClassificacoesService;
import com.tgcoord.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author natalia
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionariosRestController {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(FuncionariosRestController.class.getName());

    @Autowired
    private FuncionariosService service;

    @Autowired
    private ClassificacoesService classService;

    /**
     *
     */
    public FuncionariosRestController() {
    }

    /**
     *
     * @param fs
     */
    public FuncionariosRestController(FuncionariosService service) {
        this.service = service;
    }
    
    /**
     *
     * @return
     */
    @GetMapping
    public List<Funcionarios> listAll() {
        return this.service.findAll();
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    @GetMapping("/{pkFuncionario}")
    public Optional<Funcionarios> getById(@PathVariable Long pkFuncionario) {
        Optional<Funcionarios> funcionario = this.service.findById(pkFuncionario);
        return funcionario;
    }
    
    /**
     *
     * @param nome
     * @return
     */
    @GetMapping("/{nome}")
    public List<Funcionarios> getByName(String nome) {
        List<Funcionarios> funcionarios = this.service.findByNomeIgnoreCaseContaining(nome);
	    return funcionarios;
    }
    
    /**
     *
     * @param rg
     * @return
     */
    @GetMapping("/{rg}")
    public Funcionarios getByRg(String rg) {
        Funcionarios funcionario = this.service.findByRg(rg);
        return funcionario;
    }
    
    /**
     *
     * @param pkFuncionario
     * @param input
     */
    @PutMapping("/{pkFuncionario}")
    public void update(@PathVariable Long pkFuncionario, @RequestBody Funcionarios input) {
        service.save(input);
    }
    
    /**
     *
     * @param input
     */
    @PostMapping("/{input}")
    public void save(@RequestBody Funcionarios input) {
        service.save(input);
    }
    
    /**
     *
     * @param pkFuncionario
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long pkFuncionario) {
        service.delete(pkFuncionario);
    }

    @GetMapping("/{fkClassificacao}")
    public int quantiaClassificacao(Long fkClassificacao) {
        List<Funcionarios> funcTotal = service.findAll();
        int result = 0;
        for(int i=0;i<=funcTotal.size();i++) {
            if(funcTotal.get(i).getFkClassificacao().equals(fkClassificacao)) {
                result += 1;
            }
        }
        return result;
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }  
}
