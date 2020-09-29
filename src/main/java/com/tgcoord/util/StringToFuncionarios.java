/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.util;

import com.tgcoord.model.Classificacoes;
import java.util.logging.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author natal
 */
@Component
public class StringToFuncionarios implements Converter<String, Classificacoes> {

    /**
     *
     * @param source
     * @return
     */
    @Override
    public Classificacoes convert(String source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final Logger LOG = Logger.getLogger(StringToFuncionarios.class.getName());
    
}
