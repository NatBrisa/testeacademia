/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Gestor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author natal
 */
public interface GestorRepository extends PagingAndSortingRepository<Gestor, Long> {
    
    Optional<Gestor> findByRg(String rg);

    List<Gestor> findByNomeIgnoreCaseContaining(String nome);
    
}
