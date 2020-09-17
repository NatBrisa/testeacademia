/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.service;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.model.TelefonesFuncionarios;
import com.tgcoord.repository.FuncionariosRepository;
import com.tgcoord.repository.TelefonesFuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author natal
 */
@Service
public class TelefonesFuncionariosService {
    
    @Autowired
    private FuncionariosRepository funcionarioRepository;
    
    @Autowired
    private TelefonesFuncionariosRepository telefonesRepository;
    
    /**
     *
     * @return
     */
    public List<TelefonesFuncionarios> findAll() {
        return telefonesRepository.findAll();
    }

    /**
     *
     * @param pkTelefone
     * @return
     */
    public Optional<TelefonesFuncionarios> findById(Long pkTelefone) {
        return telefonesRepository.findById(pkTelefone);
    }
    
    /**
     *
     * @param pkFuncionario
     * @return
     */
    public TelefonesFuncionarios findByFuncionario(Funcionarios pkFuncionario) {
        return telefonesRepository.findByFkFuncionario(pkFuncionario);
    }
    
    /**
     *
     * @param tel
     * @return
     */
    public TelefonesFuncionarios save(TelefonesFuncionarios tel) {
        return telefonesRepository.saveAndFlush(tel);
    }

    /**
     *
     * @param pkTelefone
     */
    public void delete(Long pkTelefone) {
        telefonesRepository.deleteById(pkTelefone);
    }
}
