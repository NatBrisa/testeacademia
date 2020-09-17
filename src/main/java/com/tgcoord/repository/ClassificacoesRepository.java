/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Classificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author natalia
 */
@Repository
@Transactional
public interface ClassificacoesRepository extends JpaRepository<Classificacoes, Long> {

    Classificacoes getByPkClassificacao(Long pkClassificacao);
    
    /**
     *
     * @param nome
     * @return
     */
    List<Classificacoes> findByNomeIgnoreCaseContaining(String nome);
    
    List<Classificacoes> findAllByOrderByNomeAsc();
}
