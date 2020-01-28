/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

/**
 * @author natal
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Basic(optional = false)
	@Column(nullable = false, length = 45)
	private String nome;

	@Basic(optional = false)
	@Column(name = "tp_curso", nullable = false, length = 10)
	private String tpCurso;

	@Basic(optional = false)
	@Column(name = "tp_inst", length = 10)
	private String tpInst;

	@Column(name = "dt_inicio", nullable = false)
	private LocalDate dtInicio;

	@Column(name = "dt_final")
	private LocalDate dtFinal;

	@Basic
	@Column(name = "carga_h")
	private Duration cargaHoraria;

	@Basic(optional = false)
	@Column(name = "nome_inst", length = 45)
	private String nomeInst;

	@Basic
	@Column(length = 20)
	private String cidade;

	@Basic
	@Column(length = 15)
	private String situacao;

//    @ManyToMany(mappedBy = "cursos")
//    private Collection<Funcionario> funcionarios = new ArrayList<>();


	/**
	 *
	 */
	public Curso() {
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
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
	public String getTpCurso() {
		return tpCurso;
	}

	/**
	 * @param tpCurso
	 */
	public void setTpCurso(String tpCurso) {
		this.tpCurso = tpCurso;
	}

	/**
	 * @return
	 */
	public String getTpInst() {
		return tpInst;
	}

	/**
	 * @param tpInst
	 */
	public void setTpInst(String tpInst) {
		this.tpInst = tpInst;
	}

	/**
	 * @return
	 */
	public LocalDate getDtInicio() {
		return dtInicio;
	}

	/**
	 * @param dtInicio
	 */
	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	/**
	 * @return
	 */
	public LocalDate getDtFinal() {
		return dtFinal;
	}

	/**
	 * @param dtFinal
	 */
	public void setDtFinal(LocalDate dtFinal) {
		this.dtFinal = dtFinal;
	}

	/**
	 * @return
	 */
	public Duration getCargaHoraria() {
		return cargaHoraria;
	}

	/**
	 * @param cargaHoraria
	 */
	public void setCargaHoraria(Duration cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * @return
	 */
	public String getNomeInst() {
		return nomeInst;
	}

	/**
	 * @param nomeInst
	 */
	public void setNomeInst(String nomeInst) {
		this.nomeInst = nomeInst;
	}

	/**
	 * @return
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
