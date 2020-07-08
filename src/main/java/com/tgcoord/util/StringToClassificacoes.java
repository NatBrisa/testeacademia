/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.util;

import com.tgcoord.model.Classificacoes;
import com.tgcoord.service.ClassificacoesService;
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
    
    
    @Override
    public Classificacoes convert(String pkClassificacao) {
        try {
            Long pk = Long.parseLong(pkClassificacao);
            return classificacoesService.getByPkClassificacao(pk);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
