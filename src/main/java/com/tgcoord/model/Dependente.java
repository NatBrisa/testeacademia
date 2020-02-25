/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Entity;

/**
 * @author natal
 */
@Entity
public class Dependente extends Pessoa implements Serializable {
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Dependente.class.getName());

    private static final long serialVersionUID = 1L;

    public Dependente() {
    }

    public Dependente(final Long id) {
        super(id);
    }

    public Dependente(final String nome) {
        super(nome);
    }
}
