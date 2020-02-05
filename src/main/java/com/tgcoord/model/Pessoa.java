/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author natal
 */
@MappedSuperclass
public class Pessoa {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Pessoa.class.getName());

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private Long id;

	@Basic(optional = false)
	@Column(nullable = false, length = 45)
	private String nome;

	@Basic(optional = false)
	@Column(nullable = false, length = 14)
	private String rg;

	@Basic(optional = false)
	@Column(length = 14)
	private String cpf;

	@Basic(optional = true)
	@Column
	private Character gen;

	@Column(name = "dt_nasc", nullable = false)
	private LocalDate dtNasc;

	/**
	 *
	 */
	public Pessoa() {
	}

	/**
	 * @param l
	 */
	public Pessoa(final Long id) {
		this.id = id;
	}

	/**
	 * @param string
	 */
	public Pessoa(final String nome) {
		this.nome = nome;
	}

	/**
	 * @return Nome
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return Nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public String getRg() {
		return this.rg;
	}

	/**
	 * @param rg
	 */
	public void setRg(final String rg) {
		this.rg = rg;
	}

	/**
	 * @return
	 */
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * @param cpf
	 */
	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return
	 */
	public Character getGen() {
		return this.gen;
	}

	/**
	 * @param gen
	 */
	public void setGen(final Character gen) {
		this.gen = gen;
	}

	/**
	 * @return
	 */
	public LocalDate getDtNasc() {
		return this.dtNasc;
	}

	/**
	 * @param dtNasc
	 */
	public void setDtNasc(final LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(id);
		return hash;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (!Objects.equals(nome, other.nome)) {
			return false;
		}
		if (!Objects.equals(rg, other.rg)) {
			return false;
		}
		if (!Objects.equals(cpf, other.cpf)) {
			return false;
		}
		if (!Objects.equals(id, other.id)) {
			return false;
		}
		if (!Objects.equals(gen, other.gen)) {
			return false;
		}
		return Objects.equals(dtNasc, other.dtNasc);
	}

}
