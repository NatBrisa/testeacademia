/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author natal
 */
@Entity
@Table(catalog = "tgcoord", uniqueConstraints = {
    @UniqueConstraint(columnNames = "pkfuncionario", name = "UK_pkfuncionario"),
    @UniqueConstraint(columnNames = {"nome", "sobrenome"}, name = "UK_nome"),
    @UniqueConstraint(columnNames = "rg", name = "UK_rg"),
    @UniqueConstraint(columnNames = "cpf", name = "UK_cpf")
})
public class Funcionarios implements Serializable {

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Funcionarios.class.getName());
    private static final long serialVersionUID = -6105047452320515121L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkfuncionario")
    private Long pkFuncionario;

    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String nome;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String sobrenome;

    @Basic(optional = false)
    @Column(nullable = false, length = 14)
    private String rg;

    @Basic(optional = false)
    @Column(length = 14)
    private String cpf;

    @Basic
    @Column
    private Character gen;

    @Basic(optional = false)
    @Column(name = "dt_nasc", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtNasc;
    
    @ManyToOne
    private Classificacoes fkClassificacao;

    @Column(name = "dt_admissao")
    private LocalDate dtAdmissao;

    @Column(name = "dt_termino")
    private LocalDate dtTermino;

    @Embedded
    private Enderecos endereco;

    @OneToMany
    private Collection<TelefonesFuncionarios> fktelefone = new ArrayList<>();

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String pis;

//    @ManyToMany(targetEntity = Dependente.class)
//    private Collection<Dependente> dependentes = new ArrayList<>();
    
    public Funcionarios() {
    }
    
    public Funcionarios(Long pkFuncionario, String nome, String sobrenome, String rg, String cpf, Character gen, LocalDate dtNasc, Classificacoes fkClassificacao, LocalDate dtAdmissao, LocalDate dtTermino, Enderecos endereco, String email, String pis) {
        this.pkFuncionario = pkFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.gen = gen;
        this.dtNasc = dtNasc;
        this.fkClassificacao = fkClassificacao;
        this.dtAdmissao = dtAdmissao;
        this.dtTermino = dtTermino;
        this.endereco = endereco;
        this.email = email;
        this.pis = pis;
    }
    
    public Funcionarios(Long pkFuncionario, String nome, String sobrenome, String rg, String cpf, Character gen, LocalDate dtNasc, Classificacoes fkClassificacao, LocalDate dtAdmissao, LocalDate dtTermino, String uf, String municipio, String bairro, String rua, int num, String complemento, String email, String pis) {
        this.pkFuncionario = pkFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.gen = gen;
        this.dtNasc = dtNasc;
        this.fkClassificacao = fkClassificacao;
        this.dtAdmissao = dtAdmissao;
        this.dtTermino = dtTermino;
        this.endereco.setUf(uf);
        this.endereco.setMunicipio(municipio);
        this.endereco.setBairro(bairro);
        this.endereco.setRua(rua);
        this.endereco.setNum(num);
        this.endereco.setComplemento(complemento);
        this.email = email;
        this.pis = pis;
    }

    public Funcionarios(Long pkFuncionario, String nome, String sobrenome, String rg, String cpf, Character gen, LocalDate dtNasc, LocalDate dtAdmissao, LocalDate dtTermino, Enderecos endereco, String email, String pis) {
        this.pkFuncionario = pkFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.gen = gen;
        this.dtNasc = dtNasc;
        this.dtAdmissao = dtAdmissao;
        this.dtTermino = dtTermino;
        this.endereco = endereco;
        this.email = email;
        this.pis = pis;
    }

    public Funcionarios(String nome, String sobrenome, String rg, String cpf, LocalDate dtNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }

    public Long getPkFuncionario() {
        return this.pkFuncionario;
    }

    public void setPkFuncionario(Long pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Character getGen() {
        return this.gen;
    }

    public void setGen(Character gen) {
        this.gen = gen;
    }

    public LocalDate getDtNasc() {
        return this.dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }
    
    public Classificacoes getFkClassificacao() {
        return this.fkClassificacao;
    }

    public void setFkClassificacao(Classificacoes fkClassificacao) {
        this.fkClassificacao = fkClassificacao;
    }
    
    /**
     * @return
     */
    public LocalDate getDtAdmissao() {
        return this.dtAdmissao;
    }

    /**
     * @param dtAdmissao
     */
    public void setDtAdmissao(LocalDate dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    /**
     * @return
     */
    public LocalDate getDtTermino() {
        return this.dtTermino;
    }

    /**
     * @param dtTermino
     */
    public void setDtTermino(LocalDate dtTermino) {
        this.dtTermino = dtTermino;
    }

    public Enderecos getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }
    
    public Collection<TelefonesFuncionarios> getFktelefone() {
        return this.fktelefone;
    }

    public void setFktelefone(Collection<TelefonesFuncionarios> fktelefone) {
        this.fktelefone = fktelefone;
    }

    /**
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public String getPis() {
        return this.pis;
    }

    /**
     * @param pis
     */
    public void setPis(String pis) {
        this.pis = pis;
    } 

    @Override
    public String toString() {
        return "Funcionarios{" + "nome=" + this.nome + ", sobrenome=" + this.sobrenome + '}';
    }

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.pkFuncionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Funcionarios other = (Funcionarios) obj;
        return Objects.equals(this.pkFuncionario, other.pkFuncionario);
    }
}
