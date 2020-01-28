/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.enums;

/**
 * @author natal
 */
public enum Etapa {

	/**
	 *
	 */
	BI("Berçário I", "Educação Infantil"),

	/**
	 *
	 */
	MI("Maternal I", "Educação Infantil"),

	/**
	 *
	 */
	MII("Maternal II", "Educação Infantil");

	private final String etapa;
	private final String grau;

	private Etapa(String etapa, String grau) {
		this.etapa = etapa;
		this.grau = grau;
	}

	/**
	 * @return the etapa
	 */
	public String getEtapa() {
		return etapa;
	}

	/**
	 * @return the grau
	 */
	public String getGrau() {
		return grau;
	}
}
