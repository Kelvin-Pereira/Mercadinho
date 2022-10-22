package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class SalvarProdutoServer implements UnaryOperator<Produto> {

    private final ProdutoRepository repository;

    @Override
    public Produto apply(Produto produto) {
        return repository.save(produto);
    }

}
