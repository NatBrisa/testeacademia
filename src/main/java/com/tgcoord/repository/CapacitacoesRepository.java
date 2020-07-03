package com.tgcoord.repository;

import com.tgcoord.model.Capacitacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author natal
 */
@Repository
public interface CapacitacoesRepository extends JpaRepository<Capacitacoes, Long> {
}
