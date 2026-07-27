package com.mealmate.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AiMealDTO {

    private String mealName;
    private String description;
    private String category;

    private Double calories;
    private Double protein;
    private Double carbs;
    private Double fats;

    private String mealType;
    private String ingredients;
    private String recipe;

    private Integer preparationTime;

    private Boolean isVeg;

}