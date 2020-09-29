package com.tgcoord.repository;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.model.TelefonesFuncionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natalia
 */
@Repository
public interface TelefonesFuncionariosRepository extends JpaRepository<TelefonesFuncionarios, Long> {
    
    /**
     *
     * @param fkFuncionario
     * @return
     */
    TelefonesFuncionarios findByFkFuncionario(Funcionarios fkFuncionario);
}
