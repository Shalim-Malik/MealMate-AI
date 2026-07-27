package com.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPreferenceResponseDTO {

    private Long id;

    private String userName;

    private String dietType;

    private String goal;

    private String budget;

    private String region;

    private String allergies;

    private String dislikedFoods;

    private Integer mealsPerDay;

    private Boolean spicyFood;

    private Boolean seasonalFood;

    private Boolean aiAutoUpdate;
}