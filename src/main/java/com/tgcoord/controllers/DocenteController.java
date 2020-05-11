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
 * @author natal
 */
@Controller
@RequestMapping(path = "/docentesnotrest")
public class DocenteController {
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(DocenteController.class.getName());

    

    /**
     * @param model
     * @return
     */
    @RequestMapping("/buscadoc")
    public String page(final Model model) {
        //model.addAttribute("attribute", "value");
        return "buscageral";
    }

    
}
