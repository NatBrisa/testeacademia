/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
public class FuncExtra extends Funcionario {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(FuncExtra.class.getName());

	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private Funcionario id;

	@Column(length = 45)
	private String conjuge;

	@Column(name = "dt_rg")
	private LocalDate dataExpRg;

	@Column(name = "orgao_rg")
	private String orgaoExpRg;

	@Column(name = "est_civil")
	private String estadoCivil;

	@Column
	private String etnia;

	@Column(name = "nm_mae")
	private String nomeMae;

	@Column(name = "nm_pai")
	private String nomePai;

	public FuncExtra() {
	}

	public String getConjuge() {
		return this.conjuge;
	}

	public void setConjuge(final String conjuge) {
		this.conjuge = conjuge;
	}

	public LocalDate getDataExpRg() {
		return this.dataExpRg;
	}

	public void setDataExpRg(final LocalDate dataExpRg) {
		this.dataExpRg = dataExpRg;
	}

	public String getOrgaoExpRg() {
		return this.orgaoExpRg;
	}

	public void setOrgaoExpRg(final String orgaoExpRg) {
		this.orgaoExpRg = orgaoExpRg;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(final String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(final String etnia) {
		this.etnia = etnia;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(final String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(final String nomePai) {
		this.nomePai = nomePai;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(final Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FuncExtra)) {
			return false;
		}
		final FuncExtra other = (FuncExtra) object;
		return id == null ? other.id == null : id.equals(other.id);
	}

	@Override
	public String toString() {
		return "com.tgcoord.model.FuncExtra[ id=" + this.id + " ]";
	}

}
