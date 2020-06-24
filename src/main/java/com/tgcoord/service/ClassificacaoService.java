/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.service;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.repository.ClassificacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natal
 */
@Service
public class ClassificacaoService {
    
    @Autowired
    private ClassificacaoRepository repository;
    
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
}
