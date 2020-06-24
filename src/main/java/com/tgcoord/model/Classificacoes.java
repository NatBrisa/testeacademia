/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Classificacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkclassificacao")
    private Long pkClassificacao;
    
    @Basic(optional = false)
    @Column(name = "nome_classificacao", nullable = false, length = 10)
    private String nome;

    public Classificacoes() {
    }
    
    public Classificacoes(Long pkClassificacao, String nome) {
        this.pkClassificacao = pkClassificacao;
        this.nome = nome;
    }

    public Long getPkClassificacao() {
        return this.pkClassificacao;
    }

    public void setPkClassificacao(Long pkClassificacao) {
        this.pkClassificacao = pkClassificacao;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String txtnome) {
        this.nome = txtnome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (null != this.pkClassificacao ? this.pkClassificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Classificacoes)) {
            return false;
        }
        Classificacoes other = (Classificacoes) obj;
        return !(null == this.pkClassificacao ? null != other.pkClassificacao : !this.pkClassificacao.equals(other.pkClassificacao));
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Classificacao[ id=" + this.pkClassificacao + " ]";
    } 
}
