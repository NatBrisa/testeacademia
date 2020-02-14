/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Docente;
import com.tgcoord.repository.DocenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/docente")
public class DocenteRestController {

    private final DocenteRepository docRep;

    @Autowired
    public DocenteRestController(DocenteRepository docRep) {
        this.docRep = docRep;
    }
    
    @GetMapping()
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(docRep.findAll(), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return Docente
     */
    @GetMapping("/{id}")
    public Object get(@PathVariable("id") Long id) {
        Optional<Docente> docente = docRep.findById(id);
        if(docente.isPresent()) {
            return new ResponseEntity<>(docente, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<?> getByName(String nome) {
        List<Docente> docentes = docRep.findByNomeIgnoreCaseContaining(nome);
        return new ResponseEntity<>(docentes, HttpStatus.FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Docente input) {
        return new ResponseEntity<>(docRep.save(input), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Docente input) {
        return new ResponseEntity<>(docRep.save(input), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Docente> docente = docRep.findById(id);
        if(docente.isPresent()) {
            docRep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }       
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
