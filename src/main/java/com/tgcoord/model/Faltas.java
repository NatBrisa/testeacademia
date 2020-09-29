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
import javax.persistence.*;

/**
 * @author natalia
 */
@Entity
public class Faltas implements Serializable {

    private static final Logger LOG = Logger.getLogger(Faltas.class.getName());

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkfaltas")
    private Long pkFaltas;

    @Column
    private String causa;

    @Column(nullable = false)
    private LocalDate dia;

    @Column
    private int duracao = 1;

    public Faltas() {
    }

    public Long getPkFaltas() {
        return this.pkFaltas;
    }

    public void setPkFaltas(Long pkFaltas) {
        this.pkFaltas = pkFaltas;
    }

    public String getCausa() {
        return this.causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public LocalDate getDia() {
        return this.dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (null != this.pkFaltas ? this.pkFaltas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Faltas)) {
            return false;
        }
        Faltas other = (Faltas) obj;
        return Objects.equals(this.pkFaltas, other.pkFaltas);
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Falta[ id=" + this.pkFaltas + " ]";
    }
}
