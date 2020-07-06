package com.tgcoord.repository;

import com.tgcoord.model.FuncsExtras;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface FuncsExtrasRepository extends JpaRepository<FuncsExtras, Long> {

    /**
     *
     * @param nome
     * @return
     */
    List<FuncsExtras> findByNomeIgnoreCaseContaining(String nome);
}
