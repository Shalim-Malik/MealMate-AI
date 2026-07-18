package com.mealmate.backend.service;

import com.mealmate.backend.dto.MealRequestDTO;
import com.mealmate.backend.dto.MealResponseDTO;

import java.util.List;

public interface MealService {

    MealResponseDTO createMeal(MealRequestDTO requestDTO);

    List<MealResponseDTO> getAllMeals();

    MealResponseDTO getMealById(Long id);

    MealResponseDTO updateMeal(Long id, MealRequestDTO requestDTO);

    void deleteMeal(Long id);

}
