package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.mercado.mercadinho.service.ProdutoRepository.getAllProdutos;
import static com.mercado.mercadinho.service.ProdutoRepository.getById;

@Service
public class ProdutoService {


    public Page<ProdutoDTO> findByAll(Pageable pageable) {
            return getAllProdutos(pageable);
    }


    public ProdutoDTO findById(Long id) {
        return getById(id);
    }
}
