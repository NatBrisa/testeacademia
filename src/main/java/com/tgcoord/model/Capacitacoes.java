/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * Registro dos cursos concluídos pelos funcionários.
 * É o desmembramento do relacionamento N:M.
 * Tem uma PK composta.
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Capacitacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkcapacitacao")
    private Long pkCapacitacao;
    
    /*
    FK funcionario
    */
    @ManyToOne
    private Funcionarios funcionario;
    
    /*
    FK Curso
    */
    @ManyToOne
    private Cursos curso;
    
    @Basic(optional = false)
    @Column(name = "num_certificado", nullable = false)
    private int numCertificado;
    
    @Basic(optional = false)
    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dtInicio;

    @Basic(optional = false)
    @Column(name = "dt_final")
    private LocalDate dtFinal;
    
    @Basic
    @Column(length = 15)
    private String situacao;//Completo ou incompleto

    public Capacitacoes() {
    }

    public Long getPkCapacitacao() {
        return this.pkCapacitacao;
    }

    public void setPkCapacitacao(Long pkCapacitacao) {
        this.pkCapacitacao = pkCapacitacao;
    }
    
    public int getNumCertificado() {
        return numCertificado;
    }

    public void setNumCertificado(int numCertificado) {
        this.numCertificado = numCertificado;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(LocalDate dtFinal) {
        this.dtFinal = dtFinal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (null != this.pkCapacitacao ? this.pkCapacitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Capacitacoes)) {
            return false;
        }
        Capacitacoes other = (Capacitacoes) obj;
        return !(null == this.pkCapacitacao ? null != other.pkCapacitacao : !this.pkCapacitacao.equals(other.pkCapacitacao));
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Capacitacao[ id=" + this.pkCapacitacao + " ]";
    }
}
