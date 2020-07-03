package com.tgcoord.service;

import com.tgcoord.model.Capacitacoes;
import com.tgcoord.repository.CapacitacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CapacitacoesService {

    @Autowired
    private CapacitacoesRepository repository;

    public List<Capacitacoes> findAll() {
        return repository.findAll();
    }

    public Capacitacoes findOne(Long pkCapacitacao) {
        return repository.getOne(pkCapacitacao);
    }

    public Capacitacoes save(Capacitacoes capacitacao) {
        return repository.saveAndFlush(capacitacao);
    }

    public void delete(Long pkCapacitacao) {
        repository.deleteById(pkCapacitacao);
    }
    private static final Logger LOG = Logger.getLogger(CapacitacoesService.class.getName());
}
