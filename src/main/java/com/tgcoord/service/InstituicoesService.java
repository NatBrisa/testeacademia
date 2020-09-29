package com.tgcoord.service;

import com.tgcoord.model.Instituicoes;
import com.tgcoord.repository.InstituicoesRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natalia
 */
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
     * @param pkInstituicao
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
     * @param instituicao
     * @return
     */
    public Instituicoes save(Instituicoes instituicao) {
        return repository.saveAndFlush(instituicao);
    }

    /**
     *
     * @param pkInstituicao
     */
    public void delete(Long pkInstituicao) {
        repository.deleteById(pkInstituicao);
    }
    private static final Logger LOG = Logger.getLogger(InstituicoesService.class.getName());
}
