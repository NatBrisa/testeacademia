/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Funcionarios;
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

    private static final Logger LOG = Logger.getLogger(PagesController.class.getName());

    @Autowired
    public FuncionariosRestController funcControl;
    
    @GetMapping("/")
    public static String index(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
    	return "index";
    }

    @GetMapping("/funcionarios")
    public static String funcionarios() {
        return "funcionarios";
    }

    @GetMapping("/cursos")
    public static String cursos() {
        return "cursos";
    }

    @GetMapping("/instituicoes")
    public static String instituicoes() {
        return "instituicoes";
    }

    @GetMapping("/ajuda")
    public static String ajuda() {
        return "ajuda";
    }

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
