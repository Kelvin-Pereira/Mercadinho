package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class UpdateProdutoService implements BiFunction<Long, Produto, Produto> {

    private final FindByIdProdutoServer findByIdProdutoServer;
    private final SalvarProdutoServer salvarProdutoServer;
    private final MapperFacade mapper;

    @Override
    public Produto apply(Long id, Produto produto) {
        Produto entityProduto = findByIdProdutoServer.apply(id);
        mapper.map(produto, entityProduto);
        return salvarProdutoServer.apply(entityProduto);
    }
}
