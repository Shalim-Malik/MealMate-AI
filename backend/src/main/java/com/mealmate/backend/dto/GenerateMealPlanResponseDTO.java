package com.mealmate.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateMealPlanResponseDTO {

    private AiMealDTO breakfast;
    private AiMealDTO lunch;
    private AiMealDTO snack;
    private AiMealDTO dinner;

}