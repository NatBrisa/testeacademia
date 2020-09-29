/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.controllers;

import com.tgcoord.model.Cursos;
import com.tgcoord.model.Enderecos;
import com.tgcoord.model.Funcionarios;
import com.tgcoord.service.ClassificacoesService;
import com.tgcoord.service.FuncionariosService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author natalia
 */
@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private static final Logger LOG = Logger.getLogger(FuncionariosController.class.getName());

    @Autowired
    private FuncionariosService service;

    @Autowired
    private ClassificacoesService classificacoesService;

    /**
     *
     */
    public FuncionariosController() {
    }

    /**
     *
     * @param service
     */
    public FuncionariosController(FuncionariosService service) {
        this.service = service;
    }
    
    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("funcionarios.html");
        load(mv, new Funcionarios());
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
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/cadastrofunc")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("funcionarios/cadastro.html");
        load(mv, new Funcionarios());
        mv.addObject("enderecos", new Enderecos());
        mv.addObject("listaClassificacoes", classificacoesService.listAllOrderByNome());
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "**/sfunc")
    public ModelAndView save(Funcionarios funcionario) {
        ModelAndView mv = new ModelAndView("funcionarios.html");
        this.service.save(funcionario);
        load(mv, new Funcionarios());
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/edfunc/{pkFuncionario}")
    public ModelAndView edit(@PathVariable("pkFuncionario") Long id) {
        ModelAndView mv = new ModelAndView("funcionarios/cadastro.html");
        Optional<Funcionarios> funcionario = service.findById(id);
        load(mv, funcionario.get());
        return mv;
    }

//    /**
//     *
//     * @param classificacao
//     * @param funcionarios
//     */
//    @RequestMapping(method = RequestMethod.POST, value = "**/sfunc")
//    public ModelAndView cadastro(@ModelAttribute Funcionarios funcionarios, @RequestParam(value="classificacao") String classificacao) {
//        Long pkclassificacao = Long.parseLong(classificacao);
//        Classificacoes classificacaoOb = classificacoesService.getByPkClassificacao(pkclassificacao);
//        service.save(funcionarios);
//        return this.index();
//    } 
    
    /**
     *
     * @param id
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/remfunc/{pkFuncionario}")
    public ModelAndView delete(@PathVariable("pkFuncionario") Long id) {
        ModelAndView mv = new ModelAndView("funcionarios.html");
        service.delete(id);
        load(mv, new Funcionarios());
        return mv;
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
    
    public void load(ModelAndView mv, Funcionarios funcionario) {
        List<Funcionarios> lista = service.findAll();
        mv.addObject("funcionariolista", lista);
        mv.addObject("funcionario", funcionario);
    }
    
    /**
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }  
}
