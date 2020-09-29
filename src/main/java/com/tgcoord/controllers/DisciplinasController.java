/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/disciplinas")
public class DisciplinasController {
    
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/url")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }
    private static final Logger LOG = Logger.getLogger(DisciplinasController.class.getName());
    
}
