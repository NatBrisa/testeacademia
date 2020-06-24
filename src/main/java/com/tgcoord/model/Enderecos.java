/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.model;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author natal
 */
@Embeddable
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(Enderecos.class.getName());

    @Column(length = 2)
    private String uf;

    @Column(length = 25)
    private String municipio;

    @Column(length = 25)
    private String bairro;

    @Column(length = 45)
    private String rua;

    @Column
    private int num;

    @Column
    private String complemento;

    /**
     *
     */
    public Enderecos() {
    }

    /**
     * @return
     */
    public String getUf() {
        return this.uf;
    }

    /**
     * @param uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return
     */
    public String getMunicipio() {
        return this.municipio;
    }

    /**
     * @param municipio
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * @param bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return
     */
    public String getRua() {
        return this.rua;
    }

    /**
     * @param rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return
     */
    public int getNum() {
        return this.num;
    }

    /**
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }
}
