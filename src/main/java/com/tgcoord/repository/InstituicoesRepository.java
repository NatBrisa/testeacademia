package com.tgcoord.repository;

import com.tgcoord.model.Instituicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface InstituicoesRepository extends JpaRepository<Instituicoes, Long> {
}
