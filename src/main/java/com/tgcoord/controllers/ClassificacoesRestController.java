/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.service.ClassificacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/classificacoes")
public class ClassificacoesRestController {
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ClassificacoesRestController.class.getName());
    
    @Autowired
    private ClassificacoesService service;

    /**
     *
     */
    public ClassificacoesRestController() {
    }

    /**
     *
     */
    public ClassificacoesRestController(ClassificacoesService service) {
        this.service=service;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public ModelAndView classificacoes() {
        ModelAndView mv = new ModelAndView("/classificacoes.html");
        List<Classificacoes> listaC = service.findAll();
        mv.addObject("classificacoeslista", listaC);
        return mv;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Classificacoes getById(@PathVariable("id") Long id) {
        Classificacoes classificacao = this.service.findOne(id);
        return classificacao;
    }

    /**
     *
     * @param input
     * @return
     */
    @PostMapping("/{input}")
    public void save(Classificacoes input) {
        this.service.save(input);
        classificacoes();
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

        this.service.save(adi);
        this.service.save(pebii);
        this.service.save(pebiii);
        this.service.save(pebiv);
        this.service.save(pebv);
        this.service.save(monitor);
        return "index";
    }
}
