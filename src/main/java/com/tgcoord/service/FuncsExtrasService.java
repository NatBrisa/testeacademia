package com.tgcoord.service;

import com.tgcoord.model.FuncsExtras;
import com.tgcoord.repository.FuncsExtrasRepository;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natalia
 */
@Service
public class FuncsExtrasService {

    private static final Logger LOG = Logger.getLogger(FuncsExtrasService.class.getName());

    @Autowired
    private FuncsExtrasRepository repository;

    /**
     *
     * @param pkFuncionario
     * @return
     */
    public Optional<FuncsExtras> findById(Long pkFuncionario) {
        return repository.findById(pkFuncionario);
    }

    /**
     *
     * @param funcionario
     * @return
     */
    public FuncsExtras save(FuncsExtras funcionario) {
        return repository.saveAndFlush(funcionario);
    }

    /**
     *
     * @param pkFuncionario
     */
    public void delete(Long pkFuncionario) {
        repository.deleteById(pkFuncionario);
    }
}
