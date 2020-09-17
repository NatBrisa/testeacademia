package com.tgcoord.repository;

import com.tgcoord.model.Instituicoes;
import com.tgcoord.model.TelefonesInstituicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface TelefonesInstituicoesRepository extends JpaRepository<TelefonesInstituicoes, Long> {

    TelefonesInstituicoes findByFkInstituicao(Instituicoes fkInstituicao);
}
