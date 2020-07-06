/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class TelefonesFuncionarios extends Telefones {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(TelefonesFuncionarios.class.getName());
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
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
