/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.util;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.service.ClassificacoesService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author natalia
 */
@Component
public class StringToClassificacoes implements Converter<String, Classificacoes> {
    
    @Autowired
    private ClassificacoesService classificacoesService;
    
    /**
     *
     * @param source
     * @return
     */
    @Override
    public Classificacoes convert(String source) {
        try {
            Long pk = Long.parseLong(source);
            return classificacoesService.getByPkClassificacao(pk);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private static final Logger LOG = Logger.getLogger(StringToClassificacoes.class.getName());
}
