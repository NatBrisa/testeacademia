package com.tgcoord.repository;

import com.tgcoord.model.TelefonesFuncionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface TelefonesFuncionariosRepository extends JpaRepository<TelefonesFuncionarios, Long> {
}
