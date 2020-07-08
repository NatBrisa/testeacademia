/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Cursos implements Serializable {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Cursos.class.getName());

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkcurso")
    private Long pkCurso;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Basic(optional = false)
    @Column(name = "tp_curso", nullable = false, length = 10)
    private String tpCurso;

    @Basic
    @Column(name = "carga_horaria")
    private float cargaHoraria;

    @ManyToOne(targetEntity = Instituicoes.class)
    @JoinColumn(name = "fkinstituicao", foreignKey = @ForeignKey(name = "FK_instituicao"))
    private Instituicoes fkInstituicao;

    @Basic
    @Column(length = 20)
    private String cidade;

    /**
     *
     */
    public Cursos() {
    }

    /**
     * @return
     */
    public Long getPkCurso() {
        return this.pkCurso;
    }

    /**
     * @param pkCurso
     */
    public void setPkCurso(Long pkCurso) {
        this.pkCurso = pkCurso;
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
    public void setNome(String nome) {
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
    public void setTpCurso(String tpCurso) {
        this.tpCurso = tpCurso;
    }

    /**
     * @return
     */
    public float getCargaHoraria() {
        return this.cargaHoraria;
    }

    /**
     * @param cargaHoraria
     */
    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public Instituicoes getFkInstituicao() {
        return this.fkInstituicao;
    }

    public void setFkInstituicao(Instituicoes fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
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
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
