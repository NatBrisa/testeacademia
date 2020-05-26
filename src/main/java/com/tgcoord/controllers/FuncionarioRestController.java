/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Funcionario;
import com.tgcoord.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
    private static final Logger LOG = Logger.getLogger(FuncionarioRestController.class.getName());
    
    private final FuncionarioRepository funcRep;

    /**
     *
     * @param funcRep
     */
    @Autowired
    public FuncionarioRestController(FuncionarioRepository funcRep) {
        this.funcRep = funcRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(funcRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcRep.findById(id);
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
        List<Funcionario> funcionarios = funcRep.findByNomeIgnoreCaseContaining(nome);
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
    public ResponseEntity<?> getByRg(String rg) {
        Funcionario funcionario = funcRep.findByRg(rg);
        if(funcionario == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.FOUND);
        }      
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Funcionario input) {
        return new ResponseEntity<>(funcRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Funcionario input) {
        return new ResponseEntity<>(funcRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcRep.findById(id);
        if(funcionario.isPresent()) {
            funcRep.deleteById(id);
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
