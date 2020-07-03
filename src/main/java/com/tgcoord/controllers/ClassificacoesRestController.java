/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.repository.ClassificacoesRepository;
import com.tgcoord.service.ClassificacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/classificacao")
public class ClassificacoesRestController {
    
    private static final Logger LOG = Logger.getLogger(ClassificacoesRestController.class.getName());
    
    @Autowired
    private ClassificacoesRepository classRep;
    
    @Autowired
    private ClassificacoesService service;

    /**
     *
     * @param classRep
     * @param service
     */
    public ClassificacoesRestController(ClassificacoesRepository classRep, ClassificacoesService service) {
        this.classRep=classRep;
        this.service=service;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/classificacao");
        mv.addObject("classificacoes", service.findAll());
		
        return mv;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Classificacoes> classificacao = this.classRep.findById(id);
        if(classificacao.isPresent()) {
            return new ResponseEntity<>(classificacao, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     *
     * @return
     */
    @GetMapping("/create")
    public String startNew() {
        Classificacoes adi = new Classificacoes();
        adi.setNome("ADI");
        
        Classificacoes pebii = new Classificacoes();
        pebii.setNome("PEB II");
        
        Classificacoes pebiii = new Classificacoes();
        pebiii.setNome("PEB III");
        
        Classificacoes pebiv = new Classificacoes();
        pebiv.setNome("PEB IV");
        
        Classificacoes pebv = new Classificacoes();
        pebv.setNome("PEB V");
        
        Classificacoes monitor = new Classificacoes();
        monitor.setNome("Monitor");

        this.classRep.save(adi);
        this.classRep.save(pebii);
        this.classRep.save(pebiii);
        this.classRep.save(pebiv);
        this.classRep.save(pebv);
        this.classRep.save(monitor);
        return "index";
    }
}
