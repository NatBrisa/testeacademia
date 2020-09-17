package com.tgcoord.service;

import com.tgcoord.model.Faltas;
import com.tgcoord.repository.FaltasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Service
public class FaltasService {
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(FaltasService.class.getName());

    @Autowired
    private FaltasRepository repository;

    /**
     *
     * @return
     */
    public List<Faltas> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @param pkFalta
     * @return
     */
    public Faltas findOne(Long pkFalta) {
        return repository.getOne(pkFalta);
    }

    /**
     *
     * @param falta
     * @return
     */
    public Faltas save(Faltas falta) {
        return repository.saveAndFlush(falta);
    }

    /**
     *
     * @param pkFalta
     */
    public void delete(Long pkFalta) {
        repository.deleteById(pkFalta);
    }
}
