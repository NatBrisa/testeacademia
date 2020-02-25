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
	 * Construtor vazio para monitor
	 */
	public Monitor() {
	}

        /**
         * Construtor para monitor passando o id de funcionário dele
         * @param id 
         */
	public Monitor(final Funcionario id) {
            this.id = id;
	}

	/**
         * Função para retornar a quantidade de horas que o monitor precisa trabalhar em creches
	 * @return Quantidade de horas
	 */
	public Duration getQtdHoras() {
		return this.qtdHoras;
	}

	/**
         * Função para definir ou alterar a quantidade de horas que o monitor precisa trabalhar para completar sua carga horária
	 * @param qtdHoras
	 */
	public void setQtdHoras(final Duration qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	/**
         * Função para retornar a instituição em que o monitor trabalha para completar seu horário de trabalho
	 * @return Instituição
	 */
	public Instituicao getInst() {
		return this.inst;
	}

	/**
         * Função para definir ou alterar a instituição em que o monitor trabalha para completar seu horário de trabalho
	 * @param inst
	 */
	public void setInst(final Instituicao inst) {
		this.inst = inst;
	}
}
