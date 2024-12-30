package com.aluracursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator")
public class ProductGeneratorController {

    private final ChatClient chatClient;

    public ProductGeneratorController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String productGenerator() {
        var clientRequest = "Genera 5 productos ecológicos.";
        try {
            return this.chatClient.prompt()
                    .user(clientRequest)
                    .call()
                    .content();
        } catch (Exception e) {
            // Manejo de excepciones: se captura la excepción y se retorna un mensaje de error.
            return "Error al generar productos: " + e.getMessage();
        }
    }


}
