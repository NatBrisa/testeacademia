/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;


import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord", uniqueConstraints = @UniqueConstraint(columnNames = "fkfuncionario", name = "UK_fkfuncionario"))
public class Gestores implements Serializable {

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Gestores.class.getName());

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "pkgestor")
    private Long pkGestor;
    
    @JoinColumn(name = "fkfuncionario" , referencedColumnName = "pkfuncionario", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_gestor_funcionario"))
    @OneToOne(optional = false)
    private Funcionarios fkFuncionario;
    
    @Column
    private String funcao;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private String nivelAcesso;

    public Gestores() {
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNivelAcesso() {
        return this.nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
