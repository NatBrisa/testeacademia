package com.tgcoord.service;

import com.tgcoord.model.Cursos;
import com.tgcoord.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CursosService {

    @Autowired
    private CursosRepository repository;

    public List<Cursos> findAll() {
        return repository.findAll();
    }

    public Cursos findOne(Long pkCurso) {
        return repository.getOne(pkCurso);
    }

    public Cursos save(Cursos curso) {
        return repository.saveAndFlush(curso);
    }

    public void delete(Long pkCurso) {
        repository.deleteById(pkCurso);
    }
    private static final Logger LOG = Logger.getLogger(CursosService.class.getName());
}
