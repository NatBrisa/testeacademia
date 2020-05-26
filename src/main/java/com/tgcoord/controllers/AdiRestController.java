/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Adi;
import com.tgcoord.repository.AdiRepository;
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
@RequestMapping("/adi")
public class AdiRestController {
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(AdiRestController.class.getName());
    
    private final AdiRepository adiRep;

    /**
     *
     * @param adiRep
     */
    @Autowired
    private AdiRestController(AdiRepository adiRep) {
        this.adiRep = adiRep;
    }
    
    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(adiRep.findAll(), HttpStatus.OK);
    }
    
    /**
     *
     * @param id
     * @return
     * 
     * Ta diferente das outras funções d getById pq quero testar se dessa forma é melhor
     * AVISO: To bebada enquanto faço isso
     * 
     */
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value="id") Long id) {
        Optional<Adi> adi = adiRep.findById(id);
//        if(adi.isPresent()) {
//            return new ResponseEntity<>(adi, HttpStatus.FOUND);
//        } else {
//            return new ResponseEntity<>(adi, HttpStatus.NOT_FOUND);
//        }
        return adi.ifPresentOrElse((new ResponseEntity(adiRep.findById(id), HttpStatus.FOUND)), (new ResponseEntity<>(adi, HttpStatus.NOT_FOUND)));
        
    }
    
    /**
     *
     * @param nome
     * @return
     */
    @GetMapping("/{nome}")
    public ResponseEntity<?> getByName(String nome) {
        List<Adi> adis = adiRep.findByNomeIgnoreCaseContaining(nome);
	    if (adis.isEmpty()) {
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
		    return new ResponseEntity<>(adis, HttpStatus.FOUND);
	    }
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Adi input) {
        return new ResponseEntity<>(adiRep.save(input), HttpStatus.OK);
    }
    
    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Adi input) {
        return new ResponseEntity<>(adiRep.save(input), HttpStatus.CREATED);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Adi> adi = adiRep.findById(id);
        if(adi.isPresent()) {
            adiRep.deleteById(id);
            return new ResponseEntity<>(adi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(adi, HttpStatus.NOT_FOUND);
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
