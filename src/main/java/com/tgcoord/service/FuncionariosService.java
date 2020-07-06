package com.tgcoord.service;

import com.tgcoord.model.Capacitacoes;
import com.tgcoord.model.Cursos;
import com.tgcoord.model.Funcionarios;
import com.tgcoord.repository.CapacitacoesRepository;
import com.tgcoord.repository.FuncionariosRepository;
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
public class FuncionariosService {

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(FuncionariosService.class.getName());

    @Autowired
    private FuncionariosRepository repository;
    
    @Autowired
    private CapacitacoesRepository capacitacoesRepository;

    /**
     *
     * @return
     */
    public List<Funcionarios> findAll() {
        return repository.findAll();
    }

    /**
     *
     * @param pkFuncionario
     * @return
     */
    public Optional<Funcionarios> findById(Long pkFuncionario) {
        return repository.findById(pkFuncionario);
    }

    /**
     *
     * @param nome
     * @return
     */
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

    /**
     *
     * @param funcionario
     * @return
     */
    public Funcionarios save(Funcionarios funcionario) {
        return this.repository.saveAndFlush(funcionario);
    }

    /**
     *
     * @param pkFuncionario
     */
    public void delete(Long pkFuncionario) {
        repository.deleteById(pkFuncionario);
    }
    
    public List<Cursos> findAllCursos(Funcionarios funcionario) {
        List<Capacitacoes> allCapacitacoes = this.capacitacoesRepository.findAllByFkFuncionario(funcionario);
        List<Cursos> listaCursos = null;
        for(int i=0;i>allCapacitacoes.size();i++){
            listaCursos.add(allCapacitacoes.get(i).getFkCurso());
        }
        return listaCursos;
    }
}
