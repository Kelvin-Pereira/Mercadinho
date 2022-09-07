package com.mercado.mercadinho.config.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NegocioException extends RuntimeException {
    private final String codigo;

    private final List<Object> mensagemArgs = new ArrayList<>();

    public NegocioException(String codigo) {
        this.codigo = codigo;
    }

    public NegocioException(String codigo, Throwable cause) {
        super(cause);
        this.codigo = codigo;
    }

    public NegocioException addArg(Object arg) {
        this.mensagemArgs.add(arg);

        return this;
    }
}
