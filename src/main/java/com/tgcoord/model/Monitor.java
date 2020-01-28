/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
@Table(name = "monitor")
public class Monitor extends Funcionario {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Monitor.class.getName());

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private Funcionario id;

	@Column(name = "qtd_h")
	private Duration qtdHoras;

	@ManyToOne
	private Instituicao inst;

	/**
	 *
	 */
	public Monitor() {
	}

	public Monitor(Funcionario id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Duration getQtdHoras() {
		return qtdHoras;
	}

	/**
	 * @param qtdHoras
	 */
	public void setQtdHoras(Duration qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	/**
	 * @return
	 */
	public Instituicao getInst() {
		return inst;
	}

	/**
	 * @param inst
	 */
	public void setInst(Instituicao inst) {
		this.inst = inst;
	}
}
