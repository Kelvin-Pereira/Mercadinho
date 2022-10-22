package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.LongConsumer;

@Service
@RequiredArgsConstructor
public class DeleteProdutoService implements LongConsumer {

    private final ProdutoRepository repository;
    private final FindByIdProdutoServer findByIdProdutoServer;

    @Override
    public void accept(long id) {
        Produto entityProduto = findByIdProdutoServer.apply(id);
        repository.delete(entityProduto);
    }

}
