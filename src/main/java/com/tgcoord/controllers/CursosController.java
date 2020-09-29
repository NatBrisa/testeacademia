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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/cursos")
public class CursosController {

    private static final Logger LOG = Logger.getLogger(CursosController.class.getName());

    @Autowired
    private CursosService service;

    @Autowired
    private InstituicoesService instituicaoService;

    /**
     *
     */
    private CursosController() {
    }
    
    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("cursos.html");
        load(mv, new Cursos());
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

    @RequestMapping(method = RequestMethod.GET, value = "/cadastrocurso")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("cursos/cadastro.html");
        load(mv, new Cursos());
        mv.addObject("instList", instituicaoService.findAll());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "**/scurso")
    public ModelAndView save(Cursos curso) {
        ModelAndView mv = new ModelAndView("cursos.html");
        this.service.save(curso);
        load(mv, new Cursos());
        return mv;
    }
    
    /**
     *
     * @param id
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edcurso/{pkCurso}")
    public ModelAndView edit(@PathVariable("pkCurso") Long id) {
        ModelAndView mv = new ModelAndView("cursos/cadastro.html");
        Cursos curso = service.findOne(id);
        load(mv, curso);
        return mv;
    }

    /**
     *
     * @param id
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/remcurso/{pkCurso}")
    public ModelAndView delete(@PathVariable("pkCurso") Long id) {
        ModelAndView mv = new ModelAndView("cursos.html");
        service.delete(id);
        load(mv, new Cursos());
        return mv;
    }

    public void load(ModelAndView mv, Cursos curso) {
        List<Cursos> lista = service.findAll();
        mv.addObject("listacursos", lista);
        mv.addObject("curso", curso);
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    } 
}
