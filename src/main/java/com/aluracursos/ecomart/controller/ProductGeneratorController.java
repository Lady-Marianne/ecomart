package com.aluracursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator")
public class ProductGeneratorController {
    private final ChatClient chatClient;

    public ProductGeneratorController(@Qualifier("gpt-4o-mini") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    public String productGenerator(){
        try {
            var pregunta = "Generá 5 productos ecológicos.";
            return this.chatClient.prompt()
                    .user(pregunta)
                    .call()
                    .content();
        } catch (Exception e) {
            return "Error al generar los productos: " + e.getMessage();
        }
    }

}


