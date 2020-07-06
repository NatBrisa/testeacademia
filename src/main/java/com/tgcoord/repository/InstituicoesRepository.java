package com.tgcoord.repository;

import com.tgcoord.model.Instituicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author natal
 */
@Repository
public interface InstituicoesRepository extends JpaRepository<Instituicoes, Long> {

    List<Optional<Instituicoes>> findByNomeCompletoIgnoreCaseContaining(String nomeCompleto);
}
