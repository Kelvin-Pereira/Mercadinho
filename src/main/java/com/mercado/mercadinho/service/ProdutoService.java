package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final MapperFacade mapper;
    private final ProdutoRepository repository;

    public Page<Produto> findByAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Produto> findByAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public void delete(Long id) {
        Produto entityProduto = repository.findById(id).orElseThrow();
        repository.delete(entityProduto);
    }

    public Produto update(Long id, Produto produto) {
        Produto produtoSalvo = repository.findById(id).orElseThrow();
        mapper.map(produto, produtoSalvo);
        return repository.save(produtoSalvo);
    }
}
