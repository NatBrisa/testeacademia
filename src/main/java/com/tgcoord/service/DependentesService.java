package com.tgcoord.service;

import com.tgcoord.model.Dependentes;
import com.tgcoord.repository.DependentesRepository;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natalia
 */
@Service
public class DependentesService {

    private static final Logger LOG = Logger.getLogger(DependentesService.class.getName());

    @Autowired
    private DependentesRepository repository;

    /**
     *
     * @return
     */
    public List<Dependentes> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @param pkDependente
     * @return
     */
    public Dependentes findOne(Long pkDependente) {
        return repository.getOne(pkDependente);
    }

    /**
     *
     * @param dependente
     * @return
     */
    public Dependentes save(Dependentes dependente) {
        return repository.saveAndFlush(dependente);
    }

    /**
     *
     * @param pkCapacitacao
     */
    public void delete(Long pkCapacitacao) {
        repository.deleteById(pkCapacitacao);
    }
}
