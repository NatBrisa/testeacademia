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
    
    @Autowired
    private ClassificacoesRepository repository;
    
    public List<Classificacoes> findAll() {
        return repository.findAll();
    }
	
    public Classificacoes findOne(Long pkClassificacao) {
        return repository.getOne(pkClassificacao);
    }
	
    public Classificacoes save(Classificacoes classificacao) {
        return repository.saveAndFlush(classificacao);
    }
	
    public void delete(Long pkClassificacao) {
        repository.deleteById(pkClassificacao);
    }  
    private static final Logger LOG = Logger.getLogger(ClassificacoesService.class.getName());
}
