/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class TelefonesFuncionarios extends Telefones {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(TelefonesFuncionarios.class.getName());
    private static final long serialVersionUID = 2777482652902149546L;

    @ManyToOne
    private Funcionarios fkFuncionario;

    /**
     *
     */
    public TelefonesFuncionarios() {
    }

    public Funcionarios getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(Funcionarios fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }
}
