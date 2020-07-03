package com.tgcoord.repository;

import com.tgcoord.model.Faltas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author natal
 */
@Repository
public interface FaltasRepository extends JpaRepository<Faltas, Long> {
}
