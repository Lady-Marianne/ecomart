package com.aluracursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-generator")
public class ProductGeneratorController {

    private final ChatClient chatClient;

    public ProductGeneratorController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String productGenerator() {
        var clientRequest = "Genera 5 productos ecológicos.";
        return this.chatClient.prompt()
                .user(clientRequest)
                .call()
                .content();    }

}
