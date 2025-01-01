package com.aluracursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorizer")
public class ProductCategorizerController {

    private final ChatClient chatClient;

    public ProductCategorizerController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String productCategorizer(String product) {
        var systemMessage = """
                Actuá como un categorizador de productos y respondé sólo el nombre de la categoría del
                 producto informado.
                                
                Escogé una categoría de la siguiente lista:
                                
                1. Higiene Personal
                2. Electrónicos
                3. Deportes
                4. Otros
                                
                Ejemplo de uso:
                                
                Producto: Pelota de fútbol
                Respuesta: Deportes
                """;
        try {
            return this.chatClient.prompt()
                    .system(systemMessage)
                    .user(product)
                    .options(ChatOptionsBuilder.builder()
                            .withTemperature(0.85)
                            .build())
                    .call()
                    .content();
        } catch (Exception e) {
            // Manejo de excepciones: se captura la excepción y se retorna un mensaje de error.
            return "Error al categorizar el producto: " + e.getMessage();
        }
    }


}
