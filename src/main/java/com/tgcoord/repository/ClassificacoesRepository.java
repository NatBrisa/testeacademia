/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Classificacoes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface ClassificacoesRepository extends JpaRepository<Classificacoes, Long>{
    
    /**
     *
     * @param nome
     * @return
     */
    List<Classificacoes> findByNomeIgnoreCaseContaining(String nome);
}
