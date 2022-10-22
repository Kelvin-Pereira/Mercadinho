package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.LongFunction;

@Service
@RequiredArgsConstructor
public class FindByIdProdutoServer implements LongFunction<Produto> {

    private final ProdutoRepository repository;

    @Override
    public Produto apply(long id) {
        return repository.findById(id).orElseThrow();
    }

}
