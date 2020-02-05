/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
public class Falta implements Serializable {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Falta.class.getName());

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String causa;

	@Column(nullable = false)
	private LocalDate dia;

	@Column
	private int duracao = 1;

	public Falta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCausa() {
		return this.causa;
	}

	public void setCausa(final String causa) {
		this.causa = causa;
	}

	public LocalDate getDia() {
		return this.dia;
	}

	public void setDia(final LocalDate dia) {
		this.dia = dia;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public void setDuracao(final int duracao) {
		this.duracao = duracao;
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
		if (!(object instanceof Falta)) {
			return false;
		}
		final Falta other = (Falta) object;
		return id == null ? other.id == null : id.equals(other.id);
	}

	@Override
	public String toString() {
		return "com.tgcoord.model.Falta[ id=" + this.id + " ]";
	}

}
