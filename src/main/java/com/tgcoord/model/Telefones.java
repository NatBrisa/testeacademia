/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author natal
 */
@MappedSuperclass
public class Telefones implements Serializable {
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Telefones.class.getName());

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "pktelefone")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pkTelefone;
    
    @Column(length = 3)
    private String ddd;
    
    @Column(name = "numtel", length = 15)
    private String numTel;
    
    /**
     *
     */
    public Telefones() {
    }
    
    /**
     *
     * @param l
     * @param string
     * @param string1
     */
    public Telefones(Long pkTelefone, String ddd, String numTel) {
        this.pkTelefone = pkTelefone;
        this.ddd = ddd;
        this.numTel = numTel;
    }

    /**
     *
     * @param string
     * @param string1
     */
    public Telefones(String ddd, String numTel) {
        this.ddd = ddd;
        this.numTel = numTel;
    }

    /**
     *
     * @return
     */
    public Long getPkTelefone() {
        return this.pkTelefone;
    }

    /**
     *
     * @param pkTelefone
     */
    public void setPkTelefone(Long pkTelefone) {
        this.pkTelefone = pkTelefone;
    }
    
    /**
     *
     * @return
     */
    public String getDdd() {
        return this.ddd;
    }

    /**
     *
     * @param ddd
     */
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    /**
     *
     * @return
     */
    public String getNumTel() {
        return this.numTel;
    }

    /**
     *
     * @param numTel
     */
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (null != this.pkTelefone ? this.pkTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Telefones)) {
            return false;
        }
        Telefones other = (Telefones) obj;
        return Objects.equals(this.pkTelefone, other.pkTelefone);
    }

    @Override
    public String toString() {
        return "com.tgcoord.model.Telefone[ id=" + this.pkTelefone + " ]";
    }
}
