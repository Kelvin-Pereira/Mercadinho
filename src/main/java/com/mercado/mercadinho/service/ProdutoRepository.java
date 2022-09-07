package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoRepository {


    static Page<ProdutoDTO> getAllProdutos(Pageable pageable) {
        List<ProdutoDTO> produtos = getProdutos();
        return new PageImpl<>(produtos, pageable, produtos.size());
    }

    static ProdutoDTO getById(Long id) {
        List<ProdutoDTO> produtos = getProdutos();
        return produtos.get(id.intValue() - 1);
    }

    private static List<ProdutoDTO> getProdutos() {
        List<ProdutoDTO> produtoDTOList = new ArrayList<>();


        ProdutoDTO produto = new ProdutoDTO();
        produto.setId(1L);
        produto.setNome("Arroz");
        produto.setValor(12.0);
        produto.setAtivo(Boolean.TRUE);
        produto.setDescricao("Tio João");
        produtoDTOList.add(produto);

        produto.setId(2L);
        produto.setNome("Feijão");
        produto.setValor(12.0);
        produto.setAtivo(Boolean.TRUE);
        produto.setDescricao("Tio João");
        produtoDTOList.add(produto);

        produto.setId(3L);
        produto.setNome("Sal");
        produto.setValor(12.0);
        produto.setAtivo(Boolean.TRUE);
        produto.setDescricao("Cristal");
        produtoDTOList.add(produto);

        produto.setId(4L);
        produto.setNome("Guaraná");
        produto.setValor(12.0);
        produto.setAtivo(Boolean.TRUE);
        produto.setDescricao("85% Guaraná");
        produtoDTOList.add(produto);

        produto.setId(5L);
        produto.setNome("Fanta Uva");
        produto.setAtivo(Boolean.TRUE);
        produto.setDescricao("85% Uva");
        produtoDTOList.add(produto);

        produto.setId(5L);
        produto.setNome("Cola Zero");
        produto.setValor(12.0);
        produto.setAtivo(Boolean.TRUE);
        produto.setDescricao("41% Menos Açucar");
        produtoDTOList.add(produto);

        return produtoDTOList;
    }

}
