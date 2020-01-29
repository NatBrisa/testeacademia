/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
@Table(name = "docente")
public class Docente extends Funcionario {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Docente.class.getName());

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private Funcionario id;

	@Column(length = 45)
	private String cargo;

	@Column(length = 45)
	private String categoria;

	@Column(length = 45)
	private String jornada;

	@Column(length = 45)
	private String disciplina;

	@OneToMany(targetEntity = Falta.class)
	private Collection<Falta> faltas = new ArrayList<>();

	/**
	 *
	 */
	public Docente() {
		super();
	}

	public Docente(Funcionario id) {
		super();
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return
	 */
	public String getJornada() {
		return jornada;
	}

	/**
	 * @param jornada
	 */
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	/**
	 * @return
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * @param disciplina
	 */
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Collection<Falta> getFaltas() {
		return faltas;
	}

	public void setFaltas(Collection<Falta> faltas) {
		this.faltas = faltas;
	}
}