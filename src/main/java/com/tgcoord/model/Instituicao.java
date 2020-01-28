/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
public class Instituicao implements Serializable {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Instituicao.class.getName());

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nm_completo", length = 45, nullable = false)
	private String nomeCompleto;

	@Column(name = "nm_simples", length = 25)
	private String nomeSimples;

	@Embedded
	private Endereco endereco;

	@Column(length = 15)
	private String tel;

	@Column(length = 45)
	private String email;

	//private String grau;
    /*
    @OneToMany
    private Collection<Sala> salas = new ArrayList<>();

    @OneToMany
    private Collection<Monitor> monitores = new ArrayList<>();
    */

	/**
	 *
	 */
	public Instituicao() {
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
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	/**
	 * @return
	 */
	public String getNomeSimples() {
		return nomeSimples;
	}

	/**
	 * @param nomeSimples
	 */
	public void setNomeSimples(String nomeSimples) {
		this.nomeSimples = nomeSimples;
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
}
