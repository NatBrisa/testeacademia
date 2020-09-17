/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.enums;

/**
 *
 * @author natalia
 */
public enum DiaSemana {
    
    /**
     *
     */
    DOM("Domingo", 1),

    /**
     *
     */
    SEG("Segunda-Feira", 2),

    /**
     *
     */
    TER("Terça-Feira", 3),

    /**
     *
     */
    QUA("Quarta-Feira", 4),

    /**
     *
     */
    QUI("Quinta-Feira", 5),

    /**
     *
     */
    SEX("Sexta-Feira", 6),

    /**
     *
     */
    SAB("Sábado", 7);
    
    private final String nomedia;
    private final int numdia;

    private DiaSemana(String name, int ordinal) {
        this.nomedia = name;
        this.numdia = ordinal;
    }

    /**
     *
     * @return
     */
    public String getNomedia() {
        return this.nomedia;
    }

    /**
     *
     * @return
     */
    public int getNumdia() {
        return this.numdia;
    }
}
