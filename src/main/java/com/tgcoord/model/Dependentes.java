/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nome", name = "UK_nome"),
    @UniqueConstraint(columnNames = "rg", name = "UK_rg"),
    @UniqueConstraint(columnNames = "cpf", name = "UK_cpf")
})
public class Dependentes implements Serializable {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Dependentes.class.getName());

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkdependente")
    private Long pkDependente;

    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String nome;

    @Basic(optional = false)
    @Column(nullable = false, length = 14)
    private String rg;

    @Basic(optional = false)
    @Column(length = 14)
    private String cpf;

    @Basic
    @Column
    private Character gen;

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDate dtNasc;

    public Dependentes() {
    }

    public Dependentes(Long pkDependente, String nome, String rg, String cpf, Character gen, LocalDate dtNasc) {
        this.pkDependente = pkDependente;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.gen = gen;
        this.dtNasc = dtNasc;
    }

    public Dependentes(Long pkDependente, String nome, String rg, String cpf, LocalDate dtNasc) {
        this.pkDependente = pkDependente;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }

    public Long getPkDependente() {
        return this.pkDependente;
    }

    public void setPkDependente(Long pkDependente) {
        this.pkDependente = pkDependente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Character getGen() {
        return this.gen;
    }

    public void setGen(Character gen) {
        this.gen = gen;
    }

    public LocalDate getDtNasc() {
        return this.dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.pkDependente);
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
        Dependentes other = (Dependentes) obj;
        return Objects.equals(this.pkDependente, other.pkDependente);
    }
}
