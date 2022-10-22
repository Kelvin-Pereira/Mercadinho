package com.mercado.mercadinho.controller;

import com.mercado.mercadinho.config.thymeleaf.ThymeleafService;
import com.mercado.mercadinho.domain.dto.ProdutoDTO;
import com.mercado.mercadinho.domain.entity.Produto;
import com.mercado.mercadinho.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequiredArgsConstructor
@Tag(name = "Produto")
@RequestMapping("/produto")
public class ProdutoController {

    private final MapperFacade mapper;
    private final ProdutoService service;
    private final FindByAllProdutoService findByAllProdutoService;
    private final FindByIdProdutoServer findByIdProdutoServer;
    private final SalvarProdutoServer salvarProdutoServer;
    private final DeleteProdutoService deleteProdutoService;
    private final UpdateProdutoService updateProdutoService;
    private final ThymeleafService thymeleafService;

    @GetMapping
    public ResponseEntity<Page<Produto>> findByAll(Pageable pageable) {
        return ResponseEntity.ok(findByAllProdutoService.apply(pageable));
    }

    @GetMapping("/{id:[0-9]*}")
    public ResponseEntity<Produto> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(findByIdProdutoServer.apply(id));
    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> inserir(@RequestBody @Validated ProdutoDTO produto) {
        return ResponseEntity.ok(mapper.map(salvarProdutoServer.apply(mapper.map(produto, Produto.class)), ProdutoDTO.class));
    }

    @PutMapping("/{id:[0-9]*}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable("id") Long id,
                                             @RequestBody @Validated ProdutoDTO produto) {
        return ResponseEntity.ok(mapper.map(updateProdutoService.apply(id, mapper.map(produto, Produto.class)), ProdutoDTO.class));
    }

    @DeleteMapping("/{id:[0-9]*}")
    public void delete(@PathVariable("id") long id) {
        deleteProdutoService.accept(id);
        ResponseEntity.noContent().build();
    }

    @GetMapping("relatorio")
    public void relatorio(HttpServletResponse response) {
        Context context = new Context();
        context.setVariable("produtos", service.findByAll());
        try (OutputStream outStream = response.getOutputStream()) {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=produtos.pdf");
            outStream.write(thymeleafService.gerarPdf("produtos", context));
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
