package com.tgcoord.repository;

import com.tgcoord.model.Instituicoes;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natalia
 */
@Repository
public interface InstituicoesRepository extends JpaRepository<Instituicoes, Long> {

    List<Optional<Instituicoes>> findByNomeCompletoIgnoreCaseContaining(String nomeCompleto);
}
