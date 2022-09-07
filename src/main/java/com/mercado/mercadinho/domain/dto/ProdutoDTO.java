package com.mercado.mercadinho.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;

    @Schema(required = true, maxLength = 100)
    @NotNull(message = "erro.campo.obrigatorio")
    private String nome;

    @Schema(required = true)
    @NotNull(message = "erro.campo.obrigatorio")
    private Double valor;

    @Schema(required = true)
    @NotNull(message = "erro.campo.obrigatorio")
    private String descricao;

    @Schema(required = true)
    @NotNull(message = "erro.campo.obrigatorio")
    private Boolean ativo;

}
