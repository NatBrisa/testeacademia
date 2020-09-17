/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Logger;

/**
 *
 * Registro dos cursos concluídos pelos funcionários.
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Capacitacoes implements Serializable {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Capacitacoes.class.getName());

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkcapacitacao")
    private Long pkCapacitacao;
    
    /*
    FK funcionario
    */
    @ManyToOne(optional = false)
    private Funcionarios fkFuncionario;
    
    /*
    FK Curso
    */
    @ManyToOne(optional = false)
    private Cursos fkCurso;
    
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

    public Funcionarios getFkFuncionario() {
        return this.fkFuncionario;
    }

    public void setFkFuncionario(Funcionarios fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

    public Cursos getFkCurso() {
        return this.fkCurso;
    }

    public void setFkCurso(Cursos fkCurso) {
        this.fkCurso = fkCurso;
    }

    public int getNumCertificado() {
        return this.numCertificado;
    }

    public void setNumCertificado(int numCertificado) {
        this.numCertificado = numCertificado;
    }

    public LocalDate getDtInicio() {
        return this.dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFinal() {
        return this.dtFinal;
    }

    public void setDtFinal(LocalDate dtFinal) {
        this.dtFinal = dtFinal;
    }

    public String getSituacao() {
        return this.situacao;
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
