package com.mercado.mercadinho.config.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class I18nConfiguration {
    private static final Locale PT_BR = new Locale("pt", "BR");

    @Bean(name = "pouprevMessageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("locale/messages");
        source.setDefaultEncoding("UTF-8");
        source.setDefaultLocale(PT_BR);
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}
