/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Funcionarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
    
    /**
     *
     * @param rg
     * @return
     */
    public Funcionarios findByRg(String rg);

    /**
     *
     * @param email
     * @return
     */
    public Funcionarios findByEmail(String email);
    
    /**
     *
     * @param nome
     * @return
     */
    public List<Funcionarios> findByNomeIgnoreCaseContaining(String nome);
}
