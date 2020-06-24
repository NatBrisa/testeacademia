/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class TelefonesInstituicoes extends Telefones {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Instituicoes fkInstituicao;
    
    @Basic
    @Column(name = "nome_contato")
    private String nomeContato;

    public TelefonesInstituicoes() {
    }

    public Instituicoes getFkInstituicao() {
        return this.fkInstituicao;
    }

    public void setFkInstituicao(Instituicoes fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
    }
}
