package com.tgcoord.repository;

import com.tgcoord.model.Capacitacoes;
import com.tgcoord.model.Cursos;
import com.tgcoord.model.Funcionarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author natalia
 */
@Repository
public interface CapacitacoesRepository extends JpaRepository<Capacitacoes, Long> {
    
    /**
     *
     * @param fkFuncionario
     * @return
     */
    List<Capacitacoes> findAllByFkFuncionario(Funcionarios fkFuncionario);
    
    /**
     *
     * @param fkCurso
     * @return
     */
    List<Cursos> findAllByFkCurso(Cursos fkCurso);
}
