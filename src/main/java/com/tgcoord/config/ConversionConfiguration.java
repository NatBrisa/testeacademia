/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.config;

import com.tgcoord.util.StringToClassificacoes;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author natalia
 */
@Configuration
public class ConversionConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToClassificacoes());
        WebMvcConfigurer.super.addFormatters(registry); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
