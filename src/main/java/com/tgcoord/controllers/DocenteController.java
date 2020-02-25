/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Docente;
import com.tgcoord.repository.DocenteRepository;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author natal
 */
@Controller
@RequestMapping(path = "/docentesnotrest")
public class DocenteController {
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(DocenteController.class.getName());

    @Autowired
    private DocenteRepository docRep;

    /**
     * @param model
     * @return
     */
    @RequestMapping("/buscadoc")
    public String page(final Model model) {
        //model.addAttribute("attribute", "value");
        return "buscageral";
    }

    /**
     * @return
     */
    @GetMapping(path = "/caddoc")
    public String cadastroDocente() {
        return "cadastrar_docente";
    }

    /**
     * @param doc
     * @return
     */
    @RequestMapping(value = "/caddoc", method = RequestMethod.POST)
    public String cadastroDocente(final Docente doc) {
        this.docRep.save(doc);
        return "redirect: /cadastrar_docente";
    }
}
