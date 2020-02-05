/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * @author natal
 */
@Controller
public class IndexController {
	private static final Logger LOG = Logger.getLogger(IndexController.class.getName());

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
//        model.addAttribute("attribute", "value");
		return "index";
	}

	/**
	 * @return
	 */
	@RequestMapping(path = "/busca")
	public String busca() {
		return "buscageral";
	}
}
