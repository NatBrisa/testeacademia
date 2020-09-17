/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.service.ClassificacoesService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/classificacoes")
public class ClassificacoesController {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(ClassificacoesController.class.getName());
    
    @Autowired
    private ClassificacoesService service;

    /**
     *
     */
    public ClassificacoesController() {
    }

    /**
     *
     * @param service
     */
    public ClassificacoesController(ClassificacoesService service) {
        this.service=service;
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("classificacoes.html");
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
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ModelAndView save(Classificacoes classificacoes) {
        System.out.println("Classificacao: " + classificacoes);
        this.service.save(classificacoes);
        return this.index();
    }
    
    /**
     *
     * @param classificacoes
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/editar/{pkClassificacao}")
    public ModelAndView edit(Classificacoes classificacoes) {
        System.out.println("Classificacao: " + classificacoes);
        this.service.save(classificacoes);
        return this.index();
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam("remover") String id) {
        Long pkclassificacao = Long.parseLong(id);
        service.delete(pkclassificacao);
        return this.index();
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
