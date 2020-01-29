/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author natal
 */
@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Endereco.class.getName());

	@Column(length = 2)
	private String uf;

	@Column(length = 25)
	private String municipio;

	@Column(length = 25)
	private String bairro;

	@Column(length = 45)
	private String rua;

	@Column
	private int num;

	/**
	 *
	 */
	public Endereco() {
	}

	/**
	 * @return
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}
}