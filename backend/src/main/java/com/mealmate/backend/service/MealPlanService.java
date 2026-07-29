package com.mealmate.backend.service;

import com.mealmate.backend.dto.*;

import java.util.List;

public interface MealPlanService {

    MealPlanResponseDTO createMealPlan(MealPlanRequestDTO requestDTO);

    List<MealPlanResponseDTO> getAllMealPlans();

    MealPlanResponseDTO getMealPlanById(Long id);

    MealPlanResponseDTO updateMealPlan(Long id, MealPlanRequestDTO requestDTO);
    GenerateMealPlanResponseDTO generateMealPlan(Long userId);
    MealPlanResponseDTO getTodayMealPlan(Long userId);
    List<MealPlanResponseDTO> getWeeklyMealPlans(Long userId);
    GroceryListResponseDTO generateGroceryList(Long userId);
    NutritionSummaryResponseDTO getNutritionSummary(Long userId);
    void deleteMealPlan(Long id);
}