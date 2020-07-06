/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.service;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.repository.ClassificacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Service
public class ClassificacoesService {
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ClassificacoesService.class.getName());
    
    @Autowired
    private ClassificacoesRepository repository;
    
    /**
     *
     * @return
     */
    public List<Classificacoes> findAll() {
        return repository.findAll();
    }
	
    /**
     *
     * @param pkClassificacao
     * @return
     */
    public Classificacoes findOne(Long pkClassificacao) {
        return repository.getOne(pkClassificacao);
    }

    public List<Classificacoes> findByPkClassificacao(Long pkClassificacao) {
        return repository.findByPkClassificacao(pkClassificacao);
    }
	
    /**
     *
     * @param classificacao
     * @return
     */
    public Classificacoes save(Classificacoes classificacao) {
        return repository.saveAndFlush(classificacao);
    }
	
    /**
     *
     * @param pkClassificacao
     */
    public void delete(Long pkClassificacao) {
        repository.deleteById(pkClassificacao);
    }

}
