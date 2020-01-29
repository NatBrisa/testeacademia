/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author natal
 */
@RestController
@RequestMapping("/url")
public class GenericController {

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(GenericController.class.getName());
    
    /**
     * @return
     */
    @GetMapping
    public List<Object> list() {
        return null;
    }

    /**
     *
     * @return
     */
    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    /**
     *
     * @return
     */
    @RequestMapping(path = "/busca")
    public String busca() {
        return "buscageral";
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
            return null;
    }

    /**
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
            return null;
    }

    /**
     * @param input
     * @return
     */
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
            return null;
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
            return null;
    }
}
