/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.*;

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
	 * @param id
	 */
	public Pessoa(Long id) {
		this.id = id;
	}

	/**
     * @param string
	 * @param nome
	 */
	public Pessoa(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Nome
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return
	 */
	public Character getGen() {
		return gen;
	}

	/**
	 * @param gen
	 */
	public void setGen(Character gen) {
		this.gen = gen;
	}

	/**
	 * @return
	 */
	public LocalDate getDtNasc() {
		return dtNasc;
	}

	/**
	 * @param dtNasc
	 */
	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Pessoa other = (Pessoa) obj;
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		if (!Objects.equals(this.rg, other.rg)) {
			return false;
		}
		if (!Objects.equals(this.cpf, other.cpf)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.gen, other.gen)) {
			return false;
		}
		return Objects.equals(this.dtNasc, other.dtNasc);
	}

}
