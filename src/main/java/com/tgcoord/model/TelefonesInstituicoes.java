/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author natalia
 */
@Entity
@Table(catalog = "tgcoord")
public class TelefonesInstituicoes extends Telefones {

    private static final Logger LOG = Logger.getLogger(TelefonesInstituicoes.class.getName());

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Instituicoes fkInstituicao;
    
    @Basic
    @Column(name = "nome_contato")
    private String nomeContato;

    /**
     *
     */
    public TelefonesInstituicoes() {
    }

    /**
     *
     * @return
     */
    public Instituicoes getFkInstituicao() {
        return this.fkInstituicao;
    }

    /**
     *
     * @param fkInstituicao
     */
    public void setFkInstituicao(Instituicoes fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
    }

    public String getNomeContato() {
        return this.nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }
}
