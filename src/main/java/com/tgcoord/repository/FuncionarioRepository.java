/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    /**
     *
     * @param rg
     * @return
     */
    Funcionario findByRg(String rg);

    /**
     *
     * @param email
     * @return
     */
    Funcionario findByEmail(String email);
    
    /**
     *
     * @param nome
     * @return
     */
    List<Funcionario> findByNomeIgnoreCaseContaining(String nome);
}
