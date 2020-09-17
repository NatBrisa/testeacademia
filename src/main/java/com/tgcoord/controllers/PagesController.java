/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.model.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Controller
public class PagesController {

    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(PagesController.class.getName());
    
    /**
     *
     */
    @Autowired
    public FuncionariosController funcControl;

    @Autowired
    public ClassificacoesController classControl;

    /**
     *
     */
    public PagesController() {
    }

    public PagesController(FuncionariosController funcControl, ClassificacoesController classControl) {
        this.funcControl = funcControl;
        this.classControl = classControl;
    }

    /**
     *
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/")
    public static String index(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
    	return "index";
    }

    /**
     *
     * @return
     */
    @GetMapping("/ajuda")
    public static String ajuda() {
        return "ajuda";
    }



    /**
     *
     * @param rg
     * @param password
     * @param model
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String rg, String password, Model model) {
        //TODO
        ModelAndView mv = new ModelAndView("/index.html");
        return mv;
    }

    /**
     *
     * @return
     */
    @GetMapping("/cadastroclassificacao")
    public ModelAndView cadastroclassificacao() {
        ModelAndView mv = new ModelAndView("/cadastroclassificacao.html");
        mv.addObject("classificacoes", new Classificacoes());
        return mv;
    }

    /**
     *
     * @param curso
     * @return
     */
    @GetMapping("/editarcurso")
    public static ModelAndView editarcurso(@RequestParam Cursos curso) {
        ModelAndView mv = new ModelAndView("/editarcurso.html");
        mv.addObject(curso);
        return mv;
    }
}
