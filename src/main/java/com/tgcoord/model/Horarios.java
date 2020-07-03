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

    public Long getPkHorario() {
        return pkHorario;
    }

    public void setPkHorario(Long pkHorario) {
        this.pkHorario = pkHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkHorario != null ? pkHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        return !((this.pkHorario == null && other.pkHorario != null) || (this.pkHorario != null && !this.pkHorario.equals(other.pkHorario)));
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Horarios[ id=" + pkHorario + " ]";
    }
    private static final Logger LOG = Logger.getLogger(Horarios.class.getName());
    
}
