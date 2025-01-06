package com.aluracursos.ecomart.controller;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.ModelType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorizer")
public class ProductCategorizerController {

    private final ChatClient chatClient;
    public ProductCategorizerController(@Qualifier("gpt-4o-mini") ChatClient chatClient) {
        this.chatClient = chatClient;
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

        var tokens = tokenCounter(systemMessage, product);
        System.out.println("Total de Tokens: " + tokens);

        try {
            return this.chatClient.prompt()
                    .system(systemMessage)
                    .user(product)
                    .options(ChatOptionsBuilder.builder()
                            .withModel("gpt-4o-mini")
                            .withTemperature(0.85)
                            .build())
                    .advisors(new SimpleLoggerAdvisor())
                    .call()
                    .content();
        } catch (Exception e) {
            // Manejo de excepciones: se captura la excepción y se retorna un mensaje de error.
            return "Error al categorizar el producto: " + e.getMessage();
        }

    }

    public int tokenCounter(String system, String user) {
        var registry = Encodings.newDefaultEncodingRegistry();
        var enc = registry.getEncodingForModel(ModelType.GPT_4O_MINI);
        return enc.countTokens(system + user);
    }
}
