/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Docente;
import org.springframework.data.repository.CrudRepository;

/**
 * @author natal
 */
public interface DocenteRepository extends CrudRepository<Docente, Long> {

	/**
	 * @param nome
	 * @return
	 */
//	List<Docente> findByNomeIgnoreCaseContaining(String nome);
}
