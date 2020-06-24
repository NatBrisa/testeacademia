/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.tgcoord.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
    
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(FuncionarioRestController.class.getName());

	@Autowired
    private FuncionarioRepository funcRep;

	@Autowired
    private FuncionarioService service;

    /**
     *
     * @param funcRep
     */
    public FuncionarioRestController(FuncionarioRepository funcRep) {
        this.funcRep = funcRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(this.funcRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    @GetMapping("/{pkFuncionario}")
    public ResponseEntity<?> getById(@PathVariable Long pkFuncionario) {
        Optional<Funcionarios> funcionario = this.funcRep.findById(pkFuncionario);
        if(funcionario.isPresent()) {
            return new ResponseEntity<>(funcionario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     *
     * @param nome
     * @return
     */
    @GetMapping("/{nome}")
    public ResponseEntity<?> getByName(String nome) {
        List<Funcionarios> funcionarios = this.funcRep.findByNomeIgnoreCaseContaining(nome);
	    if (funcionarios.isEmpty()) {
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
		    return new ResponseEntity<>(funcionarios, HttpStatus.FOUND);
	    }
    }
    
    /**
     *
     * @param rg
     * @return
     */
    @GetMapping("/{rg}")
    public Funcionarios getByRg(String rg) {
        Funcionarios funcionario = this.funcRep.findByRg(rg);
        return funcionario;
    }
    
    /**
     *
     * @param pkFuncionario
     * @param input
     * @return
     */
    @PutMapping("/{pkFuncionario}")
    public ResponseEntity<?> update(@PathVariable Long pkFuncionario, @RequestBody Funcionarios input) {
        return new ResponseEntity<>(this.funcRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Funcionarios input) {
        return new ResponseEntity<>(this.funcRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long pkFuncionario) {
        Optional<Funcionarios> funcionario = this.funcRep.findById(pkFuncionario);
        if(funcionario.isPresent()) {
            this.funcRep.deleteById(pkFuncionario);
            return new ResponseEntity<>(funcionario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }  
}
