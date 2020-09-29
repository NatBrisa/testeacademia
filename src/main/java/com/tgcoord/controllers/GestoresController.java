/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Gestores;
import com.tgcoord.service.GestoresService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/gestor")
public class GestoresController {

    private static final Logger LOG = Logger.getLogger(GestoresController.class.getName());

    @Autowired
    private GestoresService service;

    /**
     *
     */
    public GestoresController() {
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Gestores> listAll() {
        return service.findAll();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Gestores> getById(@PathVariable Long id) {
        Optional<Gestores> gestor = service.findById(id);
        return gestor;
    }
    
    /**
     *
     * @param id
     * @param input
     */
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Gestores input) {
        this.service.save(input);
    }
    
    /**
     *
     * @param input
     */
    @PostMapping("/")
    public void save(@RequestBody Gestores input) {
        this.service.save(input);
    }
    
    /**
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
}
