/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.service;

import com.tgcoord.model.Instituicoes;
import com.tgcoord.model.TelefonesInstituicoes;
import com.tgcoord.repository.InstituicoesRepository;
import com.tgcoord.repository.TelefonesInstituicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author natal
 */
@Service
public class TelefonesInstituicoesService {
    
    @Autowired
    private InstituicoesRepository instituicoesRepository;
    
    @Autowired
    private TelefonesInstituicoesRepository telefonesRepository;
    
    /**
     *
     * @return
     */
    public List<TelefonesInstituicoes> findAll() {
        return telefonesRepository.findAll();
    }

    /**
     *
     * @param pkTelefone
     * @return
     */
    public Optional<TelefonesInstituicoes> findById(Long pkTelefone) {
        return telefonesRepository.findById(pkTelefone);
    }
    
    /**
     *
     * @return
     */
    public TelefonesInstituicoes findByFuncionario(Instituicoes pkInstituicao) {
        return telefonesRepository.findByFkInstituicao(pkInstituicao);
    }
    
    /**
     *
     * @param tel
     * @return
     */
    public TelefonesInstituicoes save(TelefonesInstituicoes tel) {
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
