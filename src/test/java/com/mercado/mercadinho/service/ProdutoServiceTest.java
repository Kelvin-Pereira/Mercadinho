package com.mercado.mercadinho.service;

import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ActiveProfiles("local")
@SpringBootTest
@RunWith(SpringRunner.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private FindByIdProdutoServer service;

    @Test
    void testBuscarPorId() {
        criarRetornoProdutoByIdRepository();
        service.apply(1L);
    }

    private void criarRetornoProdutoByIdRepository(){
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Carne");
        produto.setValor(10.23);
        produto.setDescricao("Carne de Carneiro");
        produto.setIsAtivo(Boolean.TRUE);
        Optional<Produto> optionalProduto = Optional.of(produto);
        Mockito.doReturn(optionalProduto).when(repository).findById(any(Long.class));
    }
}
