package com.tgcoord.service;

import com.tgcoord.model.Gestores;
import com.tgcoord.repository.GestoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Service
public class GestoresService {
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(GestoresService.class.getName());

    @Autowired
    private GestoresRepository repository;

    /**
     *
     * @return
     */
    public List<Gestores> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @param pkGestor
     * @return
     */
    public Optional<Gestores> findById(Long pkGestor) {
        return repository.findById(pkGestor);
    }

    /**
     *
     * @param nome
     * @return
     */
    public List<Optional<Gestores>> findByNomeIgnoreCaseContaining(String nome) {
        return this.repository.findByNomeIgnoreCaseContaining(nome);
    }

    /**
     *
     * @param rg
     * @return
     */
    public Optional<Gestores> findByRg(String rg) {
        return this.repository.findByRg(rg);
    }

    /**
     *
     * @param email
     * @return
     */
    public Optional<Gestores> findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    /**
     *
     * @param gestor
     * @return
     */
    public Gestores save(Gestores gestor) {
        return repository.saveAndFlush(gestor);
    }

    /**
     *
     * @param pkGestor
     */
    public void delete(Long pkGestor) {
        repository.deleteById(pkGestor);
    }
}
