/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public FuncionariosRestController() {
    }

    /**
     *
     * @param service
     */
    public FuncionariosRestController(FuncionariosService service) {
        this.service = service;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    @GetMapping("/{pkFuncionario}")
    public ResponseEntity<?> getById(@PathVariable Long pkFuncionario) {
        Optional<Funcionarios> funcionario = this.service.findById(pkFuncionario);
        ResponseEntity<Optional<Funcionarios>> resp;
        if(funcionario.isPresent()) {
            resp = new ResponseEntity<>(funcionario, HttpStatus.FOUND);
        } else {
            resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return resp;
    }
    
    /**
     *
     * @param nome
     * @return
     */
    @GetMapping("/{nome}")
    public ResponseEntity<?> getByName(String nome) {
        List<Funcionarios> funcionarios = this.service.findByNomeIgnoreCaseContaining(nome);
        ResponseEntity<Optional<Funcionarios>> resp;
	    if (funcionarios.isEmpty()) {
	        resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
		    resp = new ResponseEntity(funcionarios, HttpStatus.FOUND);
	    }
	    return resp;
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
     * @return
     */
    @PutMapping("/{pkFuncionario}")
    public ResponseEntity<?> update(@PathVariable Long pkFuncionario, @RequestBody Funcionarios input) {
        return new ResponseEntity<>(this.service.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/{input}")
    public ResponseEntity<?> save(@RequestBody Funcionarios input) {
        return new ResponseEntity<>(this.service.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long pkFuncionario) {
        Optional<Funcionarios> funcionario = this.service.findById(pkFuncionario);
        ResponseEntity<Optional<Funcionarios>> resp;
        if(funcionario.isPresent()) {
            this.service.delete(pkFuncionario);
            resp = new ResponseEntity<>(funcionario, HttpStatus.FOUND);
        } else {
            resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return resp;
    }

    @GetMapping("/cadastro")
    public static String cadastro() {
        return "cadastrofuncionario";
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }  
}
