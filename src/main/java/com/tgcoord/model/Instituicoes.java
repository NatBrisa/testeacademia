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
 * @author natalia
 */
@Entity
@Table(catalog = "tgcoord", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nm_completo", name = "UK_nm_completo"),
    @UniqueConstraint(columnNames = "nm_simples", name = "UK_nm_simples"),
    @UniqueConstraint(columnNames = "email", name = "UK_email")
})
public class Instituicoes implements Serializable {

    private static final Logger LOG = Logger.getLogger(Instituicoes.class.getName());

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkinstituicao")
    private Long pkInstituicao;

    @Basic(optional = false)
    @Column(name = "nm_completo", length = 45, nullable = false)
    private String nomeCompleto;

    @Column(name = "nm_simples", length = 25)
    private String nomeSimples;

    @Embedded
    private Enderecos endereco;

    @Column(length = 15)
    private String tel;

    @Column(length = 45)
    private String email;
    
    @Basic(optional = false)
    @Column(name = "tp_inst", length = 10)
    private String tpInst;
    
    /**
     *
     */
    public Instituicoes() {
    }

    /**
     * @return
     */
    public Long getPkInstituicao() {
        return this.pkInstituicao;
    }

    /**
     * @param pkInstituicao
     */
    public void setPkInstituicao(Long pkInstituicao) {
        this.pkInstituicao = pkInstituicao;
    }

    /**
     * @return
     */
    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    /**
     * @param nomeCompleto
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * @return
     */
    public String getNomeSimples() {
        return this.nomeSimples;
    }

    /**
     * @param nomeSimples
     */
    public void setNomeSimples(String nomeSimples) {
        this.nomeSimples = nomeSimples;
    }
    
    public Enderecos getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }

    /**
     * @return
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTpInst() {
        return this.tpInst;
    }

    public void setTpInst(String tpInst) {
        this.tpInst = tpInst;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.pkInstituicao);
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
        final Instituicoes other = (Instituicoes) obj;
        if (!Objects.equals(this.pkInstituicao, other.pkInstituicao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeCompleto;
    }
}
