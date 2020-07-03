/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Cursos;
import com.tgcoord.repository.CursosRepository;
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
 * @author natal
 */
@RestController
@RequestMapping("/curso")
public class CursosRestController {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(CursosRestController.class.getName());
    
    private CursosRepository cursoRep;

    /**
     *
     */
    @Autowired
    private CursosRestController(CursosRepository cursoRep) {
        super();
        this.cursoRep = cursoRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(this.cursoRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Cursos> curso = this.cursoRep.findById(id);
        if(curso.isPresent()) {
            return new ResponseEntity<>(curso, HttpStatus.FOUND);
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
        List<Cursos> cursos = this.cursoRep.findByNomeIgnoreCaseContaining(nome);
        if (cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cursos, HttpStatus.FOUND);
        }      
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cursos input) {
        return new ResponseEntity<>(this.cursoRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Cursos input) {
        return new ResponseEntity<>(this.cursoRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Cursos> curso = this.cursoRep.findById(id);
        if(curso.isPresent()) {
            this.cursoRep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
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
