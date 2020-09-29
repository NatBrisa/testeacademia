/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author natalia
 */
@Entity
@Table(catalog = "tgcoord")
public class Classificacoes implements Serializable {

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
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Classificacoes other = (Classificacoes) obj;
        return Objects.equals(this.pkClassificacao, other.pkClassificacao);
    }
}
