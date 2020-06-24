package com.tgcoord.service;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionarios> findAll() {
        return repository.findAll();
    }

    public Optional<Funcionarios> findById(Long pkFuncionario) {
        return repository.findById(pkFuncionario);
    }

    public Funcionarios save(Funcionarios funcionario) {
        return repository.saveAndFlush(funcionario);
    }

    public void delete(Long pkFuncionario) {
        repository.deleteById(pkFuncionario);
    }
}
