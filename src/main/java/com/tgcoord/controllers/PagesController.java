/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Cursos;
import com.tgcoord.model.Funcionarios;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public FuncionariosRestController funcControl;

    /**
     *
     */
    public PagesController() {
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
    @GetMapping("/cadastrofuncionario")
    public static String cadastro() {
        return "cadastrofuncionario";
    }

    /**
     *
     * @return
     */
    @GetMapping("/cursos")
    public static String cursos() {
        return "cursos";
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

    /**
     *
     * @return
     */
    @GetMapping("/instituicoes")
    public static String instituicoes() {
        return "instituicoes";
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
     * @return
     */
    @GetMapping(value = "/funcionarios")
    public ModelAndView funcionarios() {
        ModelAndView mv = new ModelAndView("/funcionarios.html");
        List<Funcionarios> lista = funcControl.listAll();
        mv.addObject(lista);
        return mv;
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
        Funcionarios func = funcControl.getByRg(rg);
        ModelAndView mv;
        if(password.equals(func.getCpf())) {
            mv = new ModelAndView("/index.html");
        } else {
            mv = new ModelAndView("/ajuda.html");
        }
        return mv;
    }
}
