package com.mealmate.backend.controller;

import com.mealmate.backend.dto.*;
import com.mealmate.backend.service.MealPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal-plans")
@RequiredArgsConstructor
public class MealPlanController {

    private final MealPlanService mealPlanService;

    @PostMapping
    public ResponseEntity<MealPlanResponseDTO> createMealPlan(
            @RequestBody MealPlanRequestDTO requestDTO) {

        return new ResponseEntity<>(
                mealPlanService.createMealPlan(requestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<MealPlanResponseDTO>> getAllMealPlans() {

        return ResponseEntity.ok(
                mealPlanService.getAllMealPlans()
        );
    }
    @GetMapping("/today/{userId}")
    public ResponseEntity<MealPlanResponseDTO> getTodayMealPlan(
            @PathVariable Long userId) {

        return ResponseEntity.ok(mealPlanService.getTodayMealPlan(userId));
    }
    @GetMapping("/weekly/{userId}")
    public ResponseEntity<List<MealPlanResponseDTO>> getWeeklyMealPlans(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                mealPlanService.getWeeklyMealPlans(userId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealPlanResponseDTO> getMealPlanById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                mealPlanService.getMealPlanById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealPlanResponseDTO> updateMealPlan(
            @PathVariable Long id,
            @RequestBody MealPlanRequestDTO requestDTO) {

        return ResponseEntity.ok(
                mealPlanService.updateMealPlan(id, requestDTO)
        );
    }
    @PostMapping("/generate")
    public ResponseEntity<GenerateMealPlanResponseDTO> generateMealPlan(
            @RequestBody GenerateMealPlanRequestDTO requestDTO) {

        return ResponseEntity.ok(
                mealPlanService.generateMealPlan(requestDTO.getUserId())
        );
    }
    @GetMapping("/grocery-list/{userId}")
    public ResponseEntity<GroceryListResponseDTO> generateGroceryList(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                mealPlanService.generateGroceryList(userId)
        );
    }
    @GetMapping("/nutrition-summary/{userId}")
    public ResponseEntity<NutritionSummaryResponseDTO> getNutritionSummary(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                mealPlanService.getNutritionSummary(userId)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMealPlan(
            @PathVariable Long id) {

        mealPlanService.deleteMealPlan(id);

        return ResponseEntity.ok("Meal Plan deleted successfully.");
    }
}