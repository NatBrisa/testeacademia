/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Gestores;
import com.tgcoord.repository.GestoresRepository;
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
public class GestoresRestController {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(GestoresRestController.class.getName());
    
    private final GestoresRepository gestRep;

    /**
     *
     * @param gestRep
     */
    @Autowired
    public GestoresRestController(GestoresRepository gestRep) {
        this.gestRep = gestRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(this.gestRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Gestores> gestor = this.gestRep.findById(id);
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
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Gestores input) {
        return new ResponseEntity<>(this.gestRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Gestores input) {
        return new ResponseEntity<>(this.gestRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Gestores> gestor = this.gestRep.findById(id);
        if(gestor.isPresent()) {
            this.gestRep.deleteById(id);
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
