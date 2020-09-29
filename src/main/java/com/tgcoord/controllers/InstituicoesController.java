/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Enderecos;
import com.tgcoord.model.Instituicoes;
import com.tgcoord.service.InstituicoesService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/instituicoes")
public class InstituicoesController {
    
    @Autowired
    private InstituicoesService service;
    
    /**
     *
     * @return
     */
    @GetMapping()
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("/instituicoes.html");
        List<Instituicoes> lista = service.findAll();
        mv.addObject("listaInstituicoes", lista);
        return mv;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    /**
     *
     * @param id
     * @param input
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    /**
     *
     * @param instituicoes
     * @return
     */
    @PostMapping(value="/cadastro")
    public ModelAndView post(@ModelAttribute Instituicoes instituicoes) {
        service.save(instituicoes);
        return this.listAll();
    }

    /**
     *
     * @return
     */
    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("/cadastroinstituicao.html");
        mv.addObject("instituicoes", new Instituicoes());
        mv.addObject("enderecos", new Enderecos());
        return mv;
    }
    
    /**
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    private static final Logger LOG = Logger.getLogger(InstituicoesController.class.getName());
    
}
