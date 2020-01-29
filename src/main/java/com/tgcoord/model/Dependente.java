/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
public class Dependente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

//    @ManyToMany(targetEntity = Funcionario.class)
//    private Collection<Funcionario> dependentes = new ArrayList<>();

	public Dependente() {
		super();
	}

	public Dependente(Long id) {
		super(id);
	}

	public Dependente(String nome) {
		super(nome);
	}

//    public Collection<Funcionario> getDependentes() {
//        return dependentes;
//    }
//
//    public void setDependentes(Collection<Funcionario> dependentes) {
//        this.dependentes = dependentes;
//    }
    private static final Logger LOG = Logger.getLogger(Dependente.class.getName());
}
