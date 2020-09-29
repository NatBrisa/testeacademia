/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.util;

import com.tgcoord.model.Classificacoes;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author natalia
 */
public class StringToClassificacoesIT {

    private static final Logger LOG = Logger.getLogger(StringToClassificacoesIT.class.getName());

    /**
     *
     */
    public StringToClassificacoesIT() {
    }

    /**
     * Test of convert method, of class StringToClassificacoes.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        String s = "";
        StringToClassificacoes instance = new StringToClassificacoes();
        Classificacoes expResult = null;
        Classificacoes result = instance.convert(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
