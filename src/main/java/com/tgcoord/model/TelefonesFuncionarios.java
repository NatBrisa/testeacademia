/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.Entity;
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
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public TelefonesFuncionarios() {
    }

//    @OneToMany(targetEntity = Funcionario.class)
//    private Funcionario fkfuncionario;
}
