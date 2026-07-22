package com.mealmate.backend.service.impl;

import com.mealmate.backend.dto.MealRequestDTO;
import com.mealmate.backend.dto.MealResponseDTO;
import com.mealmate.backend.entity.Meal;
import com.mealmate.backend.entity.User;
import com.mealmate.backend.exception.ResourceNotFoundException;
import com.mealmate.backend.repository.MealRepository;
import com.mealmate.backend.repository.UserRepository;
import com.mealmate.backend.service.MealService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;
    @Override
    public MealResponseDTO createMeal(MealRequestDTO requestDTO) {

        User user = userRepository.findById(requestDTO.getCreatedBy())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Meal meal = new Meal();

        meal.setMealName(requestDTO.getMealName());
        meal.setDescription(requestDTO.getDescription());
        meal.setCategory(requestDTO.getCategory());
        meal.setCalories(requestDTO.getCalories());
        meal.setProtein(requestDTO.getProtein());
        meal.setCarbs(requestDTO.getCarbs());
        meal.setFats(requestDTO.getFats());
        meal.setMealType(requestDTO.getMealType());
        meal.setSeason(requestDTO.getSeason());
        meal.setCuisine(requestDTO.getCuisine());
        meal.setDifficulty(requestDTO.getDifficulty());
        meal.setIsVeg(requestDTO.getIsVeg());
        meal.setImageUrl(requestDTO.getImageUrl());

        meal.setCreatedBy(user);

        Meal savedMeal = mealRepository.save(meal);

        return mapToResponse(savedMeal);
    }
    private MealResponseDTO mapToResponse(Meal meal) {

        MealResponseDTO response = new MealResponseDTO();

        response.setId(meal.getId());
        response.setMealName(meal.getMealName());
        response.setDescription(meal.getDescription());
        response.setCategory(meal.getCategory());
        response.setCalories(meal.getCalories());
        response.setProtein(meal.getProtein());
        response.setCarbs(meal.getCarbs());
        response.setFats(meal.getFats());
        response.setMealType(meal.getMealType());
        response.setSeason(meal.getSeason());
        response.setCuisine(meal.getCuisine());
        response.setDifficulty(meal.getDifficulty());
        response.setIsVeg(meal.getIsVeg());
        response.setImageUrl(meal.getImageUrl());

        if (meal.getCreatedBy() != null) {
            response.setCreatedBy(meal.getCreatedBy().getFullName());
        }

        return response;
    }
    @Override
    public List<MealResponseDTO> getAllMeals() {
        return null;
    }

    @Override
    public MealResponseDTO getMealById(Long id) {
        return null;
    }

    @Override
    public MealResponseDTO updateMeal(Long id, MealRequestDTO requestDTO) {
        return null;
    }

    @Override
    public void deleteMeal(Long id) {

    }

}