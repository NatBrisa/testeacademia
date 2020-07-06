/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Cursos;
import com.tgcoord.service.CursosService;
import com.tgcoord.service.InstituicoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/cursos")
public class CursosRestController {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(CursosRestController.class.getName());

    @Autowired
    private CursosService service;

    @Autowired
    private InstituicoesService instituicaoService;

    /**
     *
     */
    private CursosRestController() {
    }
    
    /**
     *
     * @return
     */
    @GetMapping
    public ModelAndView cursos() {
        ModelAndView mv = new ModelAndView("/cursos.html");
        List<Cursos> lista = service.findAll();
        mv.addObject("listacursos", lista);
        return mv;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Cursos getById(@PathVariable("id") Long id) {
        Cursos curso = this.service.findOne(id);
        return curso;
    }
    
    /**
     *
     * @param nome
     * @return
     */
    @GetMapping("/{nome}")
    public List<Cursos> getByName(String nome) {
        List<Cursos> cursos = this.service.findByNomeIgnoreCaseContaining(nome);
        return cursos;
    }
    
    /**
     *
     * @param id
     * @param input
     */
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Cursos input) {
        service.save(input);
    }
    
    /**
     *
     * @param input
     */
    @PostMapping("/")
    public void save(@RequestBody Cursos input) {
        service.save(input);
    }
    
    /**
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("/cadastrocurso.html");
        mv.addObject("cursos", new Cursos());
        mv.addObject("instList", instituicaoService.findAll());
        return mv;
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    } 
}
