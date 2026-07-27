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
        meal.setIngredients(requestDTO.getIngredients());
        meal.setRecipe(requestDTO.getRecipe());
        meal.setYoutubeLink(requestDTO.getYoutubeLink());
        meal.setPreparationTime(requestDTO.getPreparationTime());
        meal.setRegion(requestDTO.getRegion());
        meal.setIsActive(requestDTO.getIsActive());
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
        response.setIngredients(meal.getIngredients());
        response.setRecipe(meal.getRecipe());
        response.setYoutubeLink(meal.getYoutubeLink());
        response.setPreparationTime(meal.getPreparationTime());
        response.setRegion(meal.getRegion());
        response.setIsActive(meal.getIsActive());

        if (meal.getCreatedBy() != null) {
            response.setCreatedBy(meal.getCreatedBy().getFullName());
        }

        return response;
    }
    @Override
    public List<MealResponseDTO> getAllMeals() {

        return mealRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public MealResponseDTO getMealById(Long id) {

        Meal meal = mealRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Meal not found"));

        return mapToResponse(meal);
    }

    @Override
    public MealResponseDTO updateMeal(Long id, MealRequestDTO requestDTO) {

        Meal meal = mealRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Meal not found"));

        User user = userRepository.findById(requestDTO.getCreatedBy())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

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
        meal.setIngredients(requestDTO.getIngredients());
        meal.setRecipe(requestDTO.getRecipe());
        meal.setYoutubeLink(requestDTO.getYoutubeLink());
        meal.setPreparationTime(requestDTO.getPreparationTime());
        meal.setRegion(requestDTO.getRegion());
        meal.setIsActive(requestDTO.getIsActive());
        meal.setIsVeg(requestDTO.getIsVeg());
        meal.setImageUrl(requestDTO.getImageUrl());
        meal.setCreatedBy(user);

        Meal updatedMeal = mealRepository.save(meal);

        return mapToResponse(updatedMeal);
    }

    @Override
    public void deleteMeal(Long id) {

        Meal meal = mealRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Meal not found"));

        mealRepository.delete(meal);
    }

}