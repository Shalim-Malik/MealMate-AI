package com.mealmate.backend.controller;

import com.mealmate.backend.dto.MealRequestDTO;
import com.mealmate.backend.dto.MealResponseDTO;
import com.mealmate.backend.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    // Create Meal
    @PostMapping
    public ResponseEntity<MealResponseDTO> createMeal(
            @RequestBody MealRequestDTO requestDTO) {

        return new ResponseEntity<>(
                mealService.createMeal(requestDTO),
                HttpStatus.CREATED);
    }

    // Get All Meals
    @GetMapping
    public ResponseEntity<List<MealResponseDTO>> getAllMeals() {

        return ResponseEntity.ok(
                mealService.getAllMeals());
    }

    // Get Meal By Id
    @GetMapping("/{id}")
    public ResponseEntity<MealResponseDTO> getMealById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                mealService.getMealById(id));
    }

    // Update Meal
    @PutMapping("/{id}")
    public ResponseEntity<MealResponseDTO> updateMeal(
            @PathVariable Long id,
            @RequestBody MealRequestDTO requestDTO) {

        return ResponseEntity.ok(
                mealService.updateMeal(id, requestDTO));
    }

    // Delete Meal
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeal(
            @PathVariable Long id) {

        mealService.deleteMeal(id);

        return ResponseEntity.ok("Meal deleted successfully.");
    }
}