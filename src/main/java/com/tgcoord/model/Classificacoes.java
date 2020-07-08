/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Classificacoes implements Serializable {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Classificacoes.class.getName());
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.pkClassificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Classificacoes other = (Classificacoes) obj;
        if (!Objects.equals(this.pkClassificacao, other.pkClassificacao)) {
            return false;
        }
        return true;
    }
}
