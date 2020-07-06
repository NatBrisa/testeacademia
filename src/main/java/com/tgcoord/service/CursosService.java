package com.tgcoord.service;

import com.tgcoord.model.Cursos;
import com.tgcoord.repository.CursosRepository;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natal
 */
@Service
public class CursosService {

    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(CursosService.class.getName());

    @Autowired
    private CursosRepository repository;

    /**
     *
     */
    public CursosService() {
    }

    /**
     *
     * @return
     */
    public List<Cursos> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @param pkCurso
     * @return
     */
    public Cursos findOne(Long pkCurso) {
        return repository.getOne(pkCurso);
    }

    /**
     *
     * @param curso
     * @return
     */
    public Cursos save(Cursos curso) {
        return repository.saveAndFlush(curso);
    }

    /**
     *
     * @param pkCurso
     */
    public void delete(Long pkCurso) {
        repository.deleteById(pkCurso);
    }

    /**
     *
     * @param nome
     * @return
     */
    public List<Cursos> findByNomeIgnoreCaseContaining(String nome) {
        return repository.findByNomeIgnoreCaseContaining(nome);
    }
}
