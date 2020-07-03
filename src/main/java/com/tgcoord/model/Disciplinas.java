/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord")
public class Disciplinas implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(Disciplinas.class.getName());

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkdisciplinas")
    private Long pkDisciplinas;
    
    @Column(name = "nome", length = 25)
    private String nome;

    @ManyToMany
    private Collection<Horarios> horario = new ArrayList<Horarios>();
    
    @ManyToOne
    private Instituicoes instituicao;

    @ManyToOne
    private Funcionarios professor;
    

    public Disciplinas() {
    }

    public Long getPkDisciplinas() {
        return pkDisciplinas;
    }

    public void setPkDisciplinas(Long pkDisciplinas) {
        this.pkDisciplinas = pkDisciplinas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkDisciplinas != null ? pkDisciplinas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplinas)) {
            return false;
        }
        Disciplinas other = (Disciplinas) object;
        return !((this.pkDisciplinas == null && other.pkDisciplinas != null) || (this.pkDisciplinas != null && !this.pkDisciplinas.equals(other.pkDisciplinas)));
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Disciplinas[ id=" + pkDisciplinas + " ]";
    }
}
