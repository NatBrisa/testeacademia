/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import static javax.persistence.InheritanceType.JOINED;

/**
 * @author natal
 */
@Entity
@Table(name = "funcionario")
@Inheritance(strategy = JOINED)
public class Funcionario extends Pessoa implements Serializable {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Funcionario.class.getName());

	private static final long serialVersionUID = 1L;

	@Column(name = "dt_admissao")
	private LocalDate dtAdmissao;

	@Column(name = "dt_termino")
	private LocalDate dtTermino;

	@Embedded
	private Endereco endereco;

	@Column(length = 15)
	private String tel;

	@Column(length = 45)
	private String email;

	@Column(length = 45)
	private String pis;

	@ManyToMany(targetEntity = Curso.class)
	private Collection<Curso> cursos = new ArrayList<>();

	@ManyToMany(targetEntity = Dependente.class)
	private Collection<Dependente> dependentes = new ArrayList<>();

	/**
	 *
	 */
	public Funcionario() {
		super();
	}

	/**
	 * @return
	 */
	public LocalDate getDtAdmissao() {
		return dtAdmissao;
	}

	/**
	 * @param dtAdmissao
	 */
	public void setDtAdmissao(LocalDate dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	/**
	 * @return
	 */
	public LocalDate getDtTermino() {
		return dtTermino;
	}

	/**
	 * @param dtTermino
	 */
	public void setDtTermino(LocalDate dtTermino) {
		this.dtTermino = dtTermino;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getPis() {
		return pis;
	}

	/**
	 * @param pis
	 */
	public void setPis(String pis) {
		this.pis = pis;
	}

	public Collection<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}

	public Collection<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Collection<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
}
