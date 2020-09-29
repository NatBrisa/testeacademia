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
 * @author natalia
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
        return this.pkDisciplinas;
    }

    public void setPkDisciplinas(Long pkDisciplinas) {
        this.pkDisciplinas = pkDisciplinas;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Horarios> getHorario() {
        return this.horario;
    }

    public void setHorario(Collection<Horarios> horario) {
        this.horario = horario;
    }

    public Instituicoes getInstituicao() {
        return this.instituicao;
    }

    public void setInstituicao(Instituicoes instituicao) {
        this.instituicao = instituicao;
    }

    public Funcionarios getProfessor() {
        return this.professor;
    }

    public void setProfessor(Funcionarios professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (null != pkDisciplinas ? this.pkDisciplinas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Disciplinas)) {
            return false;
        }
        Disciplinas other = (Disciplinas) obj;
        return !(null == this.pkDisciplinas ? null != other.pkDisciplinas : !this.pkDisciplinas.equals(other.pkDisciplinas));
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Disciplinas[ id=" + this.pkDisciplinas + " ]";
    }
}
