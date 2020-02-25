/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 * @author natal
 */
@MappedSuperclass
public class Pessoa {
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Pessoa.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;

    @Basic(optional = false)
    @Column(nullable = false, length = 14)
    private String rg;

    @Basic(optional = false)
    @Column(length = 14)
    private String cpf;

    @Basic(optional = true)
    @Column
    private Character gen;

    @Column(name = "dt_nasc", nullable = false)
    private LocalDate dtNasc;

    /**
     * Construtor vazio para Pessoa
     */
    public Pessoa() {
    }

    /**
     * Construtor passando apenas o id
     * @param id
     */
    public Pessoa(final Long id) {
        this.id = id;
    }

    /**
     * Construtor passando apenas o nome
     * @param nome
     */
    public Pessoa(final String nome) {
        this.nome = nome;
    }

    /**
     * Função para retornar o id
     * @return id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Função para definir o id da pessoa
     * @param id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Função para retornar o nome da pessoa
     * @return Nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Função para definir ou alterar o nome da pessoa
     * @param nome
     */
    public void setNome(final String nome) {
        this.nome = nome;
    }

    /**
     * Função para retornar o RG
     * @return RG
     */
    public String getRg() {
        return this.rg;
    }

    /**
     * Função para definir ou alterar o RG
     * @param rg
     */
    public void setRg(final String rg) {
        this.rg = rg;
    }

    /**
     * Função para retornar o CPF
     * @return CPF
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Função para definir ou alterar o CPF
     * @param cpf
     */
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    /**
     * Função para retornar o gênero da pessoa
     * @return Gênero
     */
    public Character getGen() {
        return this.gen;
    }

    /**
     * Função para definir ou alterar o gênero da pessoa
     * @param gen
     */
    public void setGen(final Character gen) {
        this.gen = gen;
    }

    /**
     * Função para retornar a data de nascimento da pessoa
     * @return
     */
    public LocalDate getDtNasc() {
        return this.dtNasc;
    }

    /**
     * Função para definir ou alterar a data de nascimento da pessoa
     * @param dtNasc
     */
    public void setDtNasc(final LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(id);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Pessoa other = (Pessoa) obj;
        if (!Objects.equals(nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(id, other.id)) {
            return false;
        }
        if (!Objects.equals(gen, other.gen)) {
            return false;
        }
        return Objects.equals(dtNasc, other.dtNasc);
    }
}
