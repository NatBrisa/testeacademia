/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.repository;

import com.tgcoord.model.Falta;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author natal
 */
public interface FaltaRepository extends PagingAndSortingRepository<Falta, Long> {
    
}
