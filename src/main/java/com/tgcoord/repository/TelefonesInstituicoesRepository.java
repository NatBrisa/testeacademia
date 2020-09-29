package com.tgcoord.repository;

import com.tgcoord.model.Instituicoes;
import com.tgcoord.model.TelefonesInstituicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natalia
 */
@Repository
public interface TelefonesInstituicoesRepository extends JpaRepository<TelefonesInstituicoes, Long> {

    /**
     *
     * @param fkInstituicao
     * @return
     */
    TelefonesInstituicoes findByFkInstituicao(Instituicoes fkInstituicao);
}
