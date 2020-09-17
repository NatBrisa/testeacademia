/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Dependentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author natal
 */
@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long> {
    
    /**
     *
     * @param nome
     * @return
     */
    List<Dependentes> findByNomeIgnoreCaseContaining(String nome);
}
