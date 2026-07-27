package com.mealmate.backend.service;

import com.mealmate.backend.dto.GenerateMealPlanResponseDTO;
import com.mealmate.backend.dto.MealPlanRequestDTO;
import com.mealmate.backend.dto.MealPlanResponseDTO;

import java.util.List;

public interface MealPlanService {

    MealPlanResponseDTO createMealPlan(MealPlanRequestDTO requestDTO);

    List<MealPlanResponseDTO> getAllMealPlans();

    MealPlanResponseDTO getMealPlanById(Long id);

    MealPlanResponseDTO updateMealPlan(Long id, MealPlanRequestDTO requestDTO);
    GenerateMealPlanResponseDTO generateMealPlan(Long userId);

    void deleteMealPlan(Long id);
}