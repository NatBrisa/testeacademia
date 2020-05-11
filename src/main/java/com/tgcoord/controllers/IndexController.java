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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author natal
 */
@Controller
public class IndexController {
    private static final Logger LOG = Logger.getLogger(IndexController.class.getName());

    @Autowired
    private DocenteRepository docRep;
    
    /**
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        //model.addAttribute("attribute", "value");
        return "index";
    }
    
    /**
     * @param tipo
     * @param nome
     * @param cpf
     * @param rg
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(String tipo, String nome, String cpf, String rg) {
        //FuncionarioRestController result = new FuncionarioRestController(funcRep)
        return "redirect: /v1/funcionario/{nome}";
    }

    /**
     * @return
     */
    @RequestMapping(path = "/busca")
    public String busca() {
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
