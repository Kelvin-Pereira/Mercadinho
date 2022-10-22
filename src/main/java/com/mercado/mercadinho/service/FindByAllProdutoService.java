package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class FindByAllProdutoService implements Function<Pageable, Page<Produto>> {

    private final ProdutoRepository repository;

    @Override
    public Page<Produto> apply(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
