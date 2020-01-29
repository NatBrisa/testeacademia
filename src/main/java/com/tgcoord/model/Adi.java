/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author natal
 */
@Entity
@Table(name = "adi")
public class Adi extends Funcionario {

	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private Funcionario id;

	public Adi() {
	}
    private static final Logger LOG = Logger.getLogger(Adi.class.getName());
}
