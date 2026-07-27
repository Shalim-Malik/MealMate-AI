package com.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealResponseDTO {

    private Long id;
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
    private String createdBy;
    private String cuisine;
    private String difficulty;
    private String ingredients;

    private String recipe;

    private String youtubeLink;

    private Integer preparationTime;

    private String region;

    private Boolean isActive;
}