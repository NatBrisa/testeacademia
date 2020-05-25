/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Gestor;
import com.tgcoord.repository.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/gestor")
public class GestorRestController {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(GestorRestController.class.getName());
    
    private GestorRepository gestRep;

    /**
     *
     * @param gr
     */
    @Autowired
    public GestorRestController(GestorRepository gestRep) {
        this.gestRep = gestRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(gestRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<Gestor> gestor = gestRep.findById(id);
        if(gestor.isPresent()) {
            return new ResponseEntity<>(gestor, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Gestor input) {
        return new ResponseEntity<>(gestRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Gestor input) {
        return new ResponseEntity<>(gestRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Gestor> gestor = gestRep.findById(id);
        if(gestor.isPresent()) {
            gestRep.deleteById(id);
            return new ResponseEntity<>(gestor, HttpStatus.FOUND);
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
