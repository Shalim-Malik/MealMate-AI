package com.mealmate.backend.controller;

import com.mealmate.backend.dto.UserPreferenceRequestDTO;
import com.mealmate.backend.dto.UserPreferenceResponseDTO;
import com.mealmate.backend.service.UserPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
@RequiredArgsConstructor
public class UserPreferenceController {

    private final UserPreferenceService userPreferenceService;

    @PostMapping
    public ResponseEntity<UserPreferenceResponseDTO> savePreference(
            @RequestBody UserPreferenceRequestDTO requestDTO) {

        return new ResponseEntity<>(
                userPreferenceService.savePreference(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserPreferenceResponseDTO> getPreferenceByUserId(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                userPreferenceService.getPreferenceByUserId(userId)
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserPreferenceResponseDTO> updatePreference(
            @PathVariable Long userId,
            @RequestBody UserPreferenceRequestDTO requestDTO) {

        return ResponseEntity.ok(
                userPreferenceService.updatePreference(userId, requestDTO)
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deletePreference(
            @PathVariable Long userId) {

        userPreferenceService.deletePreference(userId);

        return ResponseEntity.ok("User Preference deleted successfully.");
    }
}