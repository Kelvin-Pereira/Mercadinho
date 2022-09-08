package com.mercado.mercadinho.config.mapper;

import com.mercado.mercadinho.domain.dto.ProdutoDTO;
import com.mercado.mercadinho.domain.entity.Produto;
import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ProdutoToProdutoDTO implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Produto.class, ProdutoDTO.class)
                .field("isAtivo", "ativo")
                .byDefault().register();
    }
}
