package com.tgcoord.service;

import com.tgcoord.model.Funcionarios;
import com.tgcoord.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FuncionariosService {

    private static final Logger LOG = Logger.getLogger(FuncionariosService.class.getName());

    @Autowired
    private FuncionariosRepository repository;

    public List<Funcionarios> findAll() {
        return repository.findAll();
    }

    public Optional<Funcionarios> findById(Long pkFuncionario) {
        return repository.findById(pkFuncionario);
    }

    public List<Funcionarios> findByNomeIgnoreCaseContaining(String nome) {
        return this.repository.findByNomeIgnoreCaseContaining(nome);
    }

    /**
     *
     * @param rg
     * @return
     */
    public Funcionarios findByRg(String rg) {
        return this.repository.findByRg(rg);
    }

    /**
     *
     * @param email
     * @return
     */
    public Funcionarios findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public Funcionarios save(Funcionarios funcionario) {
        return repository.saveAndFlush(funcionario);
    }

    public void delete(Long pkFuncionario) {
        repository.deleteById(pkFuncionario);
    }
}
