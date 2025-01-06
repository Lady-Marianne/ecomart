package com.aluracursos.ecomart.controller;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageGeneratorController {

    private final ImageModel imageModel;
    public ImageGeneratorController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping
    public String generateImage(String prompt) {
        var options = ImageOptionsBuilder
                .builder()
                .withHeight(1024)
                .withWidth(1024)
                .build();
        var response = imageModel.call(new ImagePrompt(prompt, options));
        return response
                .getResult()
                .getOutput()
                .getUrl();
    }

}