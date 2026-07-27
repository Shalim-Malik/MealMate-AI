package com.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MealPlanRequestDTO {

    private Long userId;

    private LocalDate mealDate;

    private Long breakfastId;

    private Long lunchId;

    private Long snackId;

    private Long dinnerId;

    private String generatedBy;

    private String status;
}