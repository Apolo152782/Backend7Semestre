package com.ProyectoDeAula5.Proyecto5.controller;

import com.ProyectoDeAula5.Proyecto5.service.GeminiApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/gemini")
@CrossOrigin(origins = "https://frontend-stackflow.azurewebsites.net") // Permite llamadas desde el frontend
public class GeminiController {

    @Autowired
    private GeminiApiService geminiApiService;

    @PostMapping("/generar")
    public Map<String, Object> generarTexto(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String respuesta = geminiApiService.generarTexto(prompt);
        return Map.of("response", respuesta);
    }

    @GetMapping("/test")
    public Map<String, Object> test() {
        String respuesta = geminiApiService.generarTexto("Dime un chiste corto");
        return Map.of("response", respuesta);
    }

}
