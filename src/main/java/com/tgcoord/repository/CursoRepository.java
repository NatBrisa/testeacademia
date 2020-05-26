/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    /**
     *
     * @param nome
     * @return
     */
    List<Curso> findByNomeIgnoreCaseContaining(String nome);
}
