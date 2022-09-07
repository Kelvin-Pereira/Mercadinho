package com.mercado.mercadinho.repository;

import com.mercado.mercadinho.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
