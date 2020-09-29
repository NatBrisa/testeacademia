/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.config;

import com.tgcoord.util.StringToClassificacoes;
import com.tgcoord.util.StringToInstituicao;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

/**
 *
 * @author natalia
 */
@Configuration
public class ConversionConfiguration implements WebMvcConfigurer {
    
    private static final Logger LOG = Logger.getLogger(ConversionConfiguration.class.getName());

    /**
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToClassificacoes());
        registry.addConverter(new StringToInstituicao());
        WebMvcConfigurer.super.addFormatters(registry); //To change body of generated methods, choose Tools | Templates.
    }
}
