/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Curso;
import com.tgcoord.repository.CursoRepository;
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
@RequestMapping(value = "/curso")
public class CursoRestController {
    private static final Logger LOG = Logger.getLogger(CursoRestController.class.getName());
    
    private final CursoRepository cursoRep;

    /**
     *
     */
    @Autowired
    private CursoRestController(CursoRepository cursoRep) {
        super();
        this.cursoRep = cursoRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(cursoRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Curso> curso = cursoRep.findById(id);
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
        List<Curso> cursos = cursoRep.findByNomeIgnoreCaseContaining(nome);
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
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Curso input) {
        return new ResponseEntity<>(cursoRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Curso input) {
        return new ResponseEntity<>(cursoRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Curso> curso = cursoRep.findById(id);
        if(curso.isPresent()) {
            cursoRep.deleteById(id);
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
