package com.mercado.mercadinho.config.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
public class ThymeleafConfig {
    @Bean
    public ThymeleafService thymeleafService(SpringTemplateEngine springTemplateEngine) {
        return new ThymeleafService(springTemplateEngine);
    }
}
