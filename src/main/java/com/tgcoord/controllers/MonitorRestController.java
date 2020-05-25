/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Monitor;
import com.tgcoord.repository.MonitorRepository;
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
@RequestMapping("/monitor")
public class MonitorRestController {
    
    private MonitorRepository monRep;

    /**
     *
     * @param mr
     */
    @Autowired
    public MonitorRestController(MonitorRepository monRep) {
        this.monRep = monRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(monRep.findAll(pageable), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Optional<Monitor> monitor = monRep.findById(id);
        if(monitor.isPresent()) {
            return new ResponseEntity<>(monitor, HttpStatus.FOUND);
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
        List<Monitor> monitores = monRep.findByNomeIgnoreCaseContaining(nome);
        if(!monitores.isEmpty()) {
            return new ResponseEntity<>(monitores, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }      
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Monitor input) {
        return new ResponseEntity<>(monRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Monitor input) {
        return new ResponseEntity<>(monRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Monitor> monitor = monRep.findById(id);
        if(monitor.isPresent()) {
            monRep.deleteById(id);
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
    private static final Logger LOG = Logger.getLogger(MonitorRestController.class.getName());
    
}
