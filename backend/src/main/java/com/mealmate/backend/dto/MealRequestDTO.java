package com.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealRequestDTO {

    private String mealName;
    private String description;
    private String category;
    private Double calories;
    private Double protein;
    private Double carbs;
    private Double fats;
    private String mealType;
    private String season;
    private Boolean isVeg;
    private String imageUrl;
    private Long createdBy;
    private String cuisine;
    private String difficulty;
}