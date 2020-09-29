package com.tgcoord.service;

import com.tgcoord.model.Capacitacoes;
import com.tgcoord.repository.CapacitacoesRepository;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natalia
 */
@Service
public class CapacitacoesService {

    private static final Logger LOG = Logger.getLogger(CapacitacoesService.class.getName());

    @Autowired
    private CapacitacoesRepository repository;

    /**
     *
     * @return
     */
    public List<Capacitacoes> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @param pkCapacitacao
     * @return
     */
    public Capacitacoes findOne(Long pkCapacitacao) {
        return repository.getOne(pkCapacitacao);
    }

    /**
     *
     * @param capacitacao
     * @return
     */
    public Capacitacoes save(Capacitacoes capacitacao) {
        return repository.saveAndFlush(capacitacao);
    }

    /**
     *
     * @param pkCapacitacao
     */
    public void delete(Long pkCapacitacao) {
        repository.deleteById(pkCapacitacao);
    }
}
