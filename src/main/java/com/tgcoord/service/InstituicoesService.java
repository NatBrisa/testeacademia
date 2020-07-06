package com.tgcoord.service;

import com.tgcoord.model.Instituicoes;
import com.tgcoord.repository.InstituicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicoesService {

    @Autowired
    private InstituicoesRepository repository;

    /**
     *
     * @return
     */
    public List<Instituicoes> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @return
     */
    public Optional<Instituicoes> findById(Long pkInstituicao) {
        return repository.findById(pkInstituicao);
    }

    /**
     *
     * @param nome
     * @return
     */
    public List<Optional<Instituicoes>> findByNomeIgnoreCaseContaining(String nome) {
        return this.repository.findByNomeCompletoIgnoreCaseContaining(nome);
    }

    /**
     *
     * @return
     */
    public Instituicoes save(Instituicoes instituicao) {
        return repository.saveAndFlush(instituicao);
    }

    /**
     *
     */
    public void delete(Long pkInstituicao) {
        repository.deleteById(pkInstituicao);
    }
}
