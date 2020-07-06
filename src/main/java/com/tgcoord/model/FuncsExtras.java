/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FuncsExtras extends Funcionarios {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(FuncsExtras.class.getName());

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "fkfuncionario" , referencedColumnName = "pkfuncionario", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_func_extra_funcionario"))
    @OneToOne(optional = false)
    private Funcionarios fkFuncionario;

    @Column(length = 45)
    private String conjuge;

    @Column(name = "dt_rg")
    private LocalDate dataExpRg;

    @Column(name = "orgao_rg", length = 10)
    private String orgaoExpRg;

    @Column(name = "est_civil", length = 20)
    private String estadoCivil;

    @Column(length = 20)
    private String etnia;

    @Column(name = "nm_mae")
    private String nomeMae;

    @Column(name = "nm_pai")
    private String nomePai;

    /**
     *
     */
    public FuncsExtras() {
    }

    /**
     *
     * @return
     */
    public String getConjuge() {
        return this.conjuge;
    }

    /**
     *
     * @param conjuge
     */
    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    /**
     *
     * @return
     */
    public LocalDate getDataExpRg() {
        return this.dataExpRg;
    }

    /**
     *
     * @param dataExpRg
     */
    public void setDataExpRg(LocalDate dataExpRg) {
        this.dataExpRg = dataExpRg;
    }

    /**
     *
     * @return
     */
    public String getOrgaoExpRg() {
        return this.orgaoExpRg;
    }

    /**
     *
     * @param orgaoExpRg
     */
    public void setOrgaoExpRg(String orgaoExpRg) {
        this.orgaoExpRg = orgaoExpRg;
    }

    /**
     *
     * @return
     */
    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    /**
     *
     * @param estadoCivil
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     *
     * @return
     */
    public String getEtnia() {
        return this.etnia;
    }

    /**
     *
     * @param etnia
     */
    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    /**
     *
     * @return
     */
    public String getNomeMae() {
        return this.nomeMae;
    }

    /**
     *
     * @param nomeMae
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     *
     * @return
     */
    public String getNomePai() {
        return this.nomePai;
    }

    /**
     *
     * @param nomePai
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
}
