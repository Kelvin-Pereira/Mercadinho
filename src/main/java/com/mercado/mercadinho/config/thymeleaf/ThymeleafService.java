package com.mercado.mercadinho.config.thymeleaf;

import com.lowagie.text.DocumentException;
import com.mercado.mercadinho.config.exceptions.NegocioException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class ThymeleafService {
    private final SpringTemplateEngine templateEngine;

    public byte[] gerarPdf(String template, Context context) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            String html = templateEngine.process(template, context);

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html, new ClassPathResource("/").getURL().toExternalForm());
            renderer.layout();
            renderer.createPDF(outputStream);

            return outputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            throw new NegocioException("thymeleaf.erro.gerar.pdf", e);
        }
    }
}
