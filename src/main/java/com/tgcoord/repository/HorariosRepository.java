package com.tgcoord.repository;

import com.tgcoord.model.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Long> {
}
