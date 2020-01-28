/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
@Table(name = "gestor")
public class Gestor extends Funcionario {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Gestor.class.getName());

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private final Funcionario id;

	public Gestor(Funcionario id) {
		this.id = id;
	}
}
