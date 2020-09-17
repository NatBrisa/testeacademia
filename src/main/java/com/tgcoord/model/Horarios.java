/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import com.tgcoord.enums.DiaSemana;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Horarios implements Serializable {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Horarios.class.getName());

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkhorario")
    private Long pkHorario;
    
    /**
     *
     */
    @Enumerated
    @Column(columnDefinition = "smallint")
    public DiaSemana dia_semana;
    
    @Column
    private LocalDate horarioInicio;
    
    @Column
    private LocalDate horarioFim;

    public Horarios() {
    }

    public Long getPkHorario() {
        return this.pkHorario;
    }

    public void setPkHorario(Long pkHorario) {
        this.pkHorario = pkHorario;
    }

    public DiaSemana getDia_semana() {
        return this.dia_semana;
    }

    public void setDia_semana(DiaSemana dia_semana) {
        this.dia_semana = dia_semana;
    }

    public LocalDate getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(LocalDate horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDate getHorarioFim() {
        return this.horarioFim;
    }

    public void setHorarioFim(LocalDate horarioFim) {
        this.horarioFim = horarioFim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (null != pkHorario ? this.pkHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) obj;
        return !((null == this.pkHorario && null != other.pkHorario) || (null != this.pkHorario && !this.pkHorario.equals(other.pkHorario)));
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Horarios[ id=" + this.pkHorario + " ]";
    }
}
