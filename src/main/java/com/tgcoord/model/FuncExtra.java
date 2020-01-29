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
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public LocalDate getDataExpRg() {
		return dataExpRg;
	}

	public void setDataExpRg(LocalDate dataExpRg) {
		this.dataExpRg = dataExpRg;
	}

	public String getOrgaoExpRg() {
		return orgaoExpRg;
	}

	public void setOrgaoExpRg(String orgaoExpRg) {
		this.orgaoExpRg = orgaoExpRg;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FuncExtra)) {
			return false;
		}
		FuncExtra other = (FuncExtra) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.tgcoord.model.FuncExtra[ id=" + id + " ]";
	}
    private static final Logger LOG = Logger.getLogger(FuncExtra.class.getName());

}
