/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 * @author natal
 */
@Entity
@Table(name = "curso", catalog = "tgcoord", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}, name = "UNIQUE_id"),
})
public class Curso implements Serializable {
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Curso.class.getName());

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nome_curso", nullable = false, length = 45)
    private String nome;

    @Basic(optional = false)
    @Column(name = "tp_curso", nullable = false, length = 10)
    private String tpCurso;

    @Basic(optional = false)
    @Column(name = "tp_inst", length = 10)
    private String tpInst;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dtInicio;

    @Column(name = "dt_final")
    private LocalDate dtFinal;

    @Basic
    @Column(name = "carga_h")
    private Duration cargaHoraria;

    @Basic(optional = false)
    @Column(name = "nome_inst", length = 45)
    private String nomeInst;

    @Basic
    @Column(length = 20)
    private String cidade;

    @Basic
    @Column(length = 15)
    private String situacao;

//    @ManyToMany(mappedBy = "cursos")
//    private Collection<Funcionario> funcionarios = new ArrayList<>();


    /**
     *
     */
    public Curso() {
    }

    /**
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome
     */
    public void setNome(final String nome) {
        this.nome = nome;
    }

    /**
     * @return
     */
    public String getTpCurso() {
        return this.tpCurso;
    }

    /**
     * @param tpCurso
     */
    public void setTpCurso(final String tpCurso) {
        this.tpCurso = tpCurso;
    }

    /**
     * @return
     */
    public String getTpInst() {
        return this.tpInst;
    }

    /**
     * @param tpInst
     */
    public void setTpInst(final String tpInst) {
        this.tpInst = tpInst;
    }

    /**
     * @return
     */
    public LocalDate getDtInicio() {
        return this.dtInicio;
    }

    /**
     * @param dtInicio
     */
    public void setDtInicio(final LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return
     */
    public LocalDate getDtFinal() {
        return this.dtFinal;
    }

    /**
     * @param dtFinal
     */
    public void setDtFinal(final LocalDate dtFinal) {
        this.dtFinal = dtFinal;
    }

    /**
     * @return
     */
    public Duration getCargaHoraria() {
        return this.cargaHoraria;
    }

    /**
     * @param cargaHoraria
     */
    public void setCargaHoraria(final Duration cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return
     */
    public String getNomeInst() {
        return this.nomeInst;
    }

    /**
     * @param nomeInst
     */
    public void setNomeInst(final String nomeInst) {
        this.nomeInst = nomeInst;
    }

    /**
     * @return
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * @param cidade
     */
    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return
     */
    public String getSituacao() {
        return this.situacao;
    }

    /**
     * @param situacao
     */
    public void setSituacao(final String situacao) {
        this.situacao = situacao;
    }
}
