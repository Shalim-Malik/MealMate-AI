package com.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MealPlanResponseDTO {

    private Long id;

    private String userName;

    private LocalDate mealDate;

    private String breakfast;

    private String lunch;

    private String snack;

    private String dinner;

    private String generatedBy;

    private String status;
}