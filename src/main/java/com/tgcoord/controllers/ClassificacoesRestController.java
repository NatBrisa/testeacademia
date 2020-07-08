/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.service.ClassificacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
     * @param service
     */
    public ClassificacoesRestController(ClassificacoesService service) {
        this.service=service;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("/classificacoes.html");
        mv.addObject("classificacoes", new Classificacoes());
        List<Classificacoes> listaC = service.listAllOrderByNome();
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
        Classificacoes classificacao = this.service.getByPkClassificacao(id);
        return classificacao;
    }

    /**
     *
     * @param classificacoes
     * @param result
     * @return 
     */
    @PostMapping(params = {"salvar"})
    public ModelAndView save(@ModelAttribute Classificacoes classificacoes, BindingResult result) {
        System.out.println("BindingResult: " + result);
        System.out.println("Classificacao: " + classificacoes);
        this.service.save(classificacoes);
        return listAll();
    }

    @RequestMapping(params = {"remover"}, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("remover") String id) {
        Long pkclassificacao = Long.parseLong(id);
        service.delete(pkclassificacao);
        return listAll();
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
