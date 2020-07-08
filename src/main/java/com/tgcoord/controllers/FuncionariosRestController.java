/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.model.Cursos;
import com.tgcoord.model.Enderecos;
import com.tgcoord.model.Funcionarios;
import com.tgcoord.service.ClassificacoesService;
import com.tgcoord.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author natalia
 */
@RestController
@RequestMapping("/funcionarios")
public class FuncionariosRestController {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(FuncionariosRestController.class.getName());

    @Autowired
    private FuncionariosService service;

    @Autowired
    private ClassificacoesService classificacoesService;

    /**
     *
     */
    public FuncionariosRestController() {
    }

    /**
     *
     */
    public FuncionariosRestController(FuncionariosService service) {
        this.service = service;
    }
    
    /**
     *
     * @return
     */
    @GetMapping
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("/funcionarios.html");
        List<Funcionarios> lista = service.findAll();
        mv.addObject("funcionariolista", lista);
        return mv;
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    @GetMapping("/{pkFuncionario}")
    public Optional<Funcionarios> getById(@PathVariable Long pkFuncionario) {
        Optional<Funcionarios> funcionario = this.service.findById(pkFuncionario);
        return funcionario;
    }
    
    /**
     *
     * @param pkFuncionario
     * @param input
     */
    @PutMapping("/{pkFuncionario}")
    public void update(@PathVariable Long pkFuncionario, @RequestBody Funcionarios input) {
        service.save(input);
    }
    
    /**
     *
     * @param classificacao
     * @param funcionarios
     */
    @PostMapping(value="/cadastro")
    public ModelAndView cadastro(@ModelAttribute Funcionarios funcionarios, @RequestParam(value="classificacao") String classificacao) {
        Long pkclassificacao = Long.parseLong(classificacao);
        Classificacoes classificacaoOb = classificacoesService.getByPkClassificacao(pkclassificacao);
        service.save(funcionarios);
        return listAll();
    }

    /**
     *
     * @return
     */
    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("/cadastrofuncionario.html");
        mv.addObject("funcionarios", new Funcionarios());
        mv.addObject("enderecos", new Enderecos());
        mv.addObject("listaClassificacoes", classificacoesService.listAllOrderByNome());
        return mv;
    }
    
    /**
     *
     * @param id
     * @return 
     */
    @RequestMapping(params = {"remover"}, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("remover") String id) {
        Long pkfuncionario = Long.parseLong(id);
        service.delete(pkfuncionario);
        return listAll();
    }

    @GetMapping("/class/{fkClassificacao}")
    public int quantiaClassificacao(Long fkClassificacao) {
        List<Funcionarios> funcTotal = service.findAll();
        int result = 0;
        for(int i=0;i<=funcTotal.size();i++) {
            if(funcTotal.get(i).getFkClassificacao().equals(fkClassificacao)) {
                result += 1;
            }
        }
        return result;
    }
    
    @GetMapping("/{id}/listacurso")
    public ModelAndView listCursos(@RequestBody Funcionarios input) {
        ModelAndView mv = new ModelAndView("/.html");
        List<Cursos> listacursos = service.findAllCursos(input);
        mv.addObject("funcionarios", input);
        mv.addObject("listacursos", listacursos);
        return mv;
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }  
}
