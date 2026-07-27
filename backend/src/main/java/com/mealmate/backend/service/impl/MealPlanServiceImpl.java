package com.mealmate.backend.service.impl;

import com.mealmate.backend.dto.AiMealDTO;
import com.mealmate.backend.dto.GenerateMealPlanResponseDTO;
import com.mealmate.backend.dto.MealPlanRequestDTO;
import com.mealmate.backend.dto.MealPlanResponseDTO;
import com.mealmate.backend.entity.Meal;
import com.mealmate.backend.entity.MealPlan;
import com.mealmate.backend.entity.User;
import com.mealmate.backend.entity.UserPreference;
import com.mealmate.backend.exception.ResourceNotFoundException;
import com.mealmate.backend.repository.MealPlanRepository;
import com.mealmate.backend.repository.MealRepository;
import com.mealmate.backend.repository.UserRepository;
import com.mealmate.backend.service.MealPlanService;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.mealmate.backend.repository.UserPreferenceRepository;
import com.mealmate.backend.ai.GeminiService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealPlanServiceImpl implements MealPlanService {

    private final MealPlanRepository mealPlanRepository;
    private final UserRepository userRepository;
    private final MealRepository mealRepository;
    private final UserPreferenceRepository userPreferenceRepository;
    private final GeminiService geminiService;
    private Meal saveMeal(AiMealDTO dto, User user) {

        Meal meal = new Meal();

        meal.setMealName(dto.getMealName());
        meal.setDescription(dto.getDescription());
        meal.setCategory(dto.getCategory());

        meal.setCalories(dto.getCalories());
        meal.setProtein(dto.getProtein());
        meal.setCarbs(dto.getCarbs());
        meal.setFats(dto.getFats());

        meal.setMealType(dto.getMealType());
        meal.setIngredients(dto.getIngredients());
        meal.setRecipe(dto.getRecipe());

        meal.setPreparationTime(dto.getPreparationTime());
        meal.setIsVeg(dto.getIsVeg());

        meal.setCreatedBy(user);

        return mealRepository.save(meal);
    }

    @Override
    public MealPlanResponseDTO createMealPlan(MealPlanRequestDTO requestDTO) {

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Meal breakfast = mealRepository.findById(requestDTO.getBreakfastId())
                .orElseThrow(() -> new ResourceNotFoundException("Breakfast meal not found"));

        Meal lunch = mealRepository.findById(requestDTO.getLunchId())
                .orElseThrow(() -> new ResourceNotFoundException("Lunch meal not found"));

        Meal snack = mealRepository.findById(requestDTO.getSnackId())
                .orElseThrow(() -> new ResourceNotFoundException("Snack meal not found"));

        Meal dinner = mealRepository.findById(requestDTO.getDinnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Dinner meal not found"));

        MealPlan mealPlan = new MealPlan();

        mealPlan.setUser(user);
        mealPlan.setMealDate(LocalDate.now());
        mealPlan.setMealDate(requestDTO.getMealDate());
        mealPlan.setBreakfast(breakfast);
        mealPlan.setLunch(lunch);
        mealPlan.setSnack(snack);
        mealPlan.setDinner(dinner);
        mealPlan.setGeneratedBy(requestDTO.getGeneratedBy());
        mealPlan.setStatus(requestDTO.getStatus());

        MealPlan savedMealPlan = mealPlanRepository.save(mealPlan);

        return mapToResponse(savedMealPlan);
    }

    @Override
    public List<MealPlanResponseDTO> getAllMealPlans() {

        return mealPlanRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MealPlanResponseDTO getMealPlanById(Long id) {

        MealPlan mealPlan = mealPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal Plan not found"));

        return mapToResponse(mealPlan);
    }

    @Override
    public MealPlanResponseDTO updateMealPlan(Long id,
                                              MealPlanRequestDTO requestDTO) {

        MealPlan mealPlan = mealPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal Plan not found"));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Meal breakfast = mealRepository.findById(requestDTO.getBreakfastId())
                .orElseThrow(() -> new ResourceNotFoundException("Breakfast meal not found"));

        Meal lunch = mealRepository.findById(requestDTO.getLunchId())
                .orElseThrow(() -> new ResourceNotFoundException("Lunch meal not found"));

        Meal snack = mealRepository.findById(requestDTO.getSnackId())
                .orElseThrow(() -> new ResourceNotFoundException("Snack meal not found"));

        Meal dinner = mealRepository.findById(requestDTO.getDinnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Dinner meal not found"));

        mealPlan.setUser(user);
        mealPlan.setMealDate(requestDTO.getMealDate());
        mealPlan.setBreakfast(breakfast);
        mealPlan.setLunch(lunch);
        mealPlan.setSnack(snack);
        mealPlan.setDinner(dinner);
        mealPlan.setGeneratedBy(requestDTO.getGeneratedBy());
        mealPlan.setStatus(requestDTO.getStatus());

        MealPlan updatedMealPlan = mealPlanRepository.save(mealPlan);

        return mapToResponse(updatedMealPlan);
    }


    @Override
    public void deleteMealPlan(Long id) {

        MealPlan mealPlan = mealPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal Plan not found"));

        mealPlanRepository.delete(mealPlan);
    }
    @Override
    public GenerateMealPlanResponseDTO generateMealPlan(Long userId) {



        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserPreference preference = userPreferenceRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Preference not found"));
        String prompt = """
Generate a healthy meal plan for the following user.

Diet Type: %s
Goal: %s
Budget: %s
Region: %s
Allergies: %s
Disliked Foods: %s
Meals Per Day: %d
Spicy Food: %s
Seasonal Food: %s

Provide the response ONLY in valid JSON.

Format:



{
  "breakfast": {
    "mealName": "",
    "description": "",
    "category": "Breakfast",
    "calories": 0,
    "protein": 0,
    "carbs": 0,
    "fats": 0,
    "mealType": "",
    "ingredients": "",
    "recipe": "",
    "preparationTime": 0,
    "isVeg": true
  },
  "lunch": {
    "mealName": "",
    "description": "",
    "category": "Lunch",
    "calories": 0,
    "protein": 0,
    "carbs": 0,
    "fats": 0,
    "mealType": "",
    "ingredients": "",
    "recipe": "",
    "preparationTime": 0,
    "isVeg": true
  },
  "snack": {
    "mealName": "",
    "description": "",
    "category": "Snack",
    "calories": 0,
    "protein": 0,
    "carbs": 0,
    "fats": 0,
    "mealType": "",
    "ingredients": "",
    "recipe": "",
    "preparationTime": 0,
    "isVeg": true
  },
  "dinner": {
    "mealName": "",
    "description": "",
    "category": "Dinner",
    "calories": 0,
    "protein": 0,
    "carbs": 0,
    "fats": 0,
    "mealType": "",
    "ingredients": "",
    "recipe": "",
    "preparationTime": 0,
    "isVeg": true
  }
}

Rules:
- Return ONLY valid JSON.
- No markdown.
- No explanation.
- Numeric fields must be numbers.
- Boolean fields must be true/false.
- Do not add extra text before or after the JSON.
- Meals should be practical, healthy, affordable and suitable for India.
""".formatted(
                preference.getDietType(),
                preference.getGoal(),
                preference.getBudget(),
                preference.getRegion(),
                preference.getAllergies(),
                preference.getDislikedFoods(),
                preference.getMealsPerDay(),
                preference.getSpicyFood(),
                preference.getSeasonalFood()
        );
        String aiResponse = geminiService.generateContent(prompt);

        ObjectMapper objectMapper = new ObjectMapper();
        GenerateMealPlanResponseDTO response;

        try {
            response = objectMapper.readValue(
                    aiResponse,
                    GenerateMealPlanResponseDTO.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI response", e);
        }

        Meal breakfast = saveMeal(response.getBreakfast(), user);
        Meal lunch = saveMeal(response.getLunch(), user);
        Meal snack = saveMeal(response.getSnack(), user);
        Meal dinner = saveMeal(response.getDinner(), user);

        MealPlan mealPlan = new MealPlan();

        mealPlan.setUser(user);

        mealPlan.setMealDate(LocalDate.now());

        mealPlan.setBreakfast(breakfast);
        mealPlan.setLunch(lunch);
        mealPlan.setSnack(snack);
        mealPlan.setDinner(dinner);

        mealPlan.setGeneratedBy("AI");
        mealPlan.setStatus("GENERATED");
        mealPlanRepository.save(mealPlan);

        return response;
    }

    private MealPlanResponseDTO mapToResponse(MealPlan mealPlan) {

        MealPlanResponseDTO response = new MealPlanResponseDTO();

        response.setId(mealPlan.getId());
        response.setUserName(mealPlan.getUser().getFullName());
        response.setMealDate(mealPlan.getMealDate());

        response.setBreakfast(mealPlan.getBreakfast().getMealName());
        response.setLunch(mealPlan.getLunch().getMealName());
        response.setSnack(mealPlan.getSnack().getMealName());
        response.setDinner(mealPlan.getDinner().getMealName());

        response.setGeneratedBy(mealPlan.getGeneratedBy());
        response.setStatus(mealPlan.getStatus());

        return response;
    }
}