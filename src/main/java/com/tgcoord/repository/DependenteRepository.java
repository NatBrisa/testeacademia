/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Dependente;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author natal
 */
public interface DependenteRepository extends PagingAndSortingRepository<Dependente, Long> {
    
    /**
     *
     * @param nome
     * @return
     */
    List<Dependente> findByNomeIgnoreCaseContaining(String nome);
}
