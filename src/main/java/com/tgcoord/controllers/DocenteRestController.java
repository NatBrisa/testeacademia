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
@RequestMapping("/docente")
public class DocenteRestController {
    private static final Logger LOG = Logger.getLogger(DocenteRestController.class.getName());

    private final DocenteRepository docRep;

    /**
     *
     * @param docRep
     */
    @Autowired
    public DocenteRestController(DocenteRepository docRep) {
        this.docRep = docRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(docRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return Docente
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Docente> docente = docRep.findById(id);
        if(docente.isPresent()) {
            return new ResponseEntity<>(docente, HttpStatus.FOUND);
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
        List<Docente> docentes = docRep.findByNomeIgnoreCaseContaining(nome);
        if (docentes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(docentes, HttpStatus.FOUND);
        }      
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Docente input) {
        return new ResponseEntity<>(docRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Docente input) {
        return new ResponseEntity<>(docRep.save(input), HttpStatus.CREATED);
    }
    
    /**
     *
     * @param id
     * @return
     */
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
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
