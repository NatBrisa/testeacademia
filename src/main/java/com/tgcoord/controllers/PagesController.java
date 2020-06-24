/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    public FuncionarioRestController funcControl;
    
    @GetMapping("/")
    public static String index(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
    	return "index";
    }

    @GetMapping("/cadastro")
    public static String cadastroteste() {
        return "cadastrosteste";
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
