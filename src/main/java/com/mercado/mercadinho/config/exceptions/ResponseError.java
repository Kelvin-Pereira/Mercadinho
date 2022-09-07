package com.mercado.mercadinho.config.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Schema(name = "Erro")
public class ResponseError {
    private int code;
    private String description;
    private String detail;
    private Map<String, String> fields = new HashMap<>();
}
