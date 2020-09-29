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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/classificacoes")
public class ClassificacoesController {

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
        load(mv, new Classificacoes());
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
    @RequestMapping(method = RequestMethod.POST, value = "**/sclass")
    public ModelAndView save(Classificacoes classificacoes) {
        ModelAndView mv = new ModelAndView("classificacoes.html");
        this.service.save(classificacoes);
        load(mv, new Classificacoes());
        return mv;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edclass/{pkClassificacao}")
    public ModelAndView edit(@PathVariable("pkClassificacao") Long id) {
        ModelAndView mv = new ModelAndView("classificacoes.html");
        Classificacoes classificacao = service.getByPkClassificacao(id);
        load(mv, classificacao);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remclass/{pkClassificacao}")
    public ModelAndView delete(@PathVariable("pkClassificacao") Long id) {
        ModelAndView mv = new ModelAndView("classificacoes.html");
        service.delete(id);
        load(mv, new Classificacoes());
        return mv;
    }
    
    /**
     *
     * @param mv
     * @param classificacao
     * Carrega os dados do banco e adiciona no ModelAndView
     */
    public void load(ModelAndView mv, Classificacoes classificacao) {
        List<Classificacoes> listaC = service.listAllOrderByNome();
        mv.addObject("classificacoeslista", listaC);
        mv.addObject("classificacoes", classificacao);
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
