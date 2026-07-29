package com.mealmate.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionSummaryResponseDTO {

    private Double totalCalories;
    private Double totalProtein;
    private Double totalCarbs;
    private Double totalFats;

}