package com.tgcoord.util;

import com.tgcoord.model.Instituicoes;
import com.tgcoord.service.InstituicoesService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author natal
 */
@Component
public class StringToInstituicao implements Converter<String, Instituicoes> {
    
    private static final Logger LOG = Logger.getLogger(StringToInstituicao.class.getName());

    @Autowired
    private InstituicoesService instituicoesService;

    /**
     *
     * @param source
     * @return
     */
    @Override
    public Instituicoes convert(String source) {
        try {
            Long pk = Long.parseLong(source);
            return instituicoesService.findById(pk).get();
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
