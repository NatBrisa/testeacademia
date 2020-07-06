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

    public Long getPkGestor() {
        return this.pkGestor;
    }

    public void setPkGestor(Long pkGestor) {
        this.pkGestor = pkGestor;
    }

    public Funcionarios getFkFuncionario() {
        return this.fkFuncionario;
    }

    public void setFkFuncionario(Funcionarios fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
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
