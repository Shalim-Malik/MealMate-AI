package com.mealmate.backend.ai;

import com.mealmate.backend.dto.GeminiRequestDTO;
import com.mealmate.backend.dto.GeminiResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiService geminiService;

    @PostMapping("/generate")
    public GeminiResponseDTO generate(@RequestBody GeminiRequestDTO request) {

        String response = geminiService.generateContent(request.getPrompt());

        return new GeminiResponseDTO(response);
    }
}