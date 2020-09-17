/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.model.Gestores;
import com.tgcoord.service.FuncionariosService;
import com.tgcoord.service.GestoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 *
 * @author natal
 */
@Repository
public interface GestoresRepository extends JpaRepository<Gestores, Long> {

    /**
     *
     */
    @Autowired
    FuncionariosService funcService = new FuncionariosService();

    /**
     *
     */
    @Autowired
    GestoresService gestService = new GestoresService();

    /**
     *
     * @param nome
     * @return
     */
    default List<Optional<Gestores>> findByNomeIgnoreCaseContaining(String nome) {
        List<Funcionarios> funcionarios = funcService.findByNomeIgnoreCaseContaining(nome);
        List<Optional<Gestores>> gestores = null;
        for(int i=0; i<= funcionarios.size(); i++) {
            Long gestPk = funcionarios.get(i).getPkFuncionario();
            Optional<Gestores> gestor = gestService.findById(gestPk);
            gestores.add(gestor);
        }
        return gestores;
    }

    /**
     *
     * @param rg
     * @return
     */
    default Optional<Gestores> findByRg(String rg) {
        Funcionarios funcionario = funcService.findByRg(rg);
        Long gestPk = funcionario.getPkFuncionario();
        Optional<Gestores> gestor = gestService.findById(gestPk);
        return gestor;
    }

    /**
     *
     * @param email
     * @return
     */
    default Optional<Gestores> findByEmail(String email) {
        Funcionarios funcionario = funcService.findByEmail(email);
        Long gestPk = funcionario.getPkFuncionario();
        Optional<Gestores> gestor = gestService.findById(gestPk);
        return gestor;
    }
}
