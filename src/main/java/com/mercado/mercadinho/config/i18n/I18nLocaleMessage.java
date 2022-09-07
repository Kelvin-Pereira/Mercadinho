package com.mercado.mercadinho.config.i18n;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class I18nLocaleMessage {
    private static ResourceBundleMessageSource messageSource;

    public I18nLocaleMessage(@Qualifier("pouprevMessageSource") ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static String toLocale(String codigo) {
        return toLocale(codigo, null);
    }

    public static String toLocale(String codigo, Object... args) {
        return messageSource.getMessage(codigo, args, LocaleContextHolder.getLocale());
    }
}
