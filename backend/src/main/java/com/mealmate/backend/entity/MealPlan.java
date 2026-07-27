package com.mealmate.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meal_plans")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Date
    private LocalDate mealDate;

    // Meals
    @ManyToOne
    @JoinColumn(name = "breakfast_id")
    private Meal breakfast;

    @ManyToOne
    @JoinColumn(name = "lunch_id")
    private Meal lunch;

    @ManyToOne
    @JoinColumn(name = "snack_id")
    private Meal snack;

    @ManyToOne
    @JoinColumn(name = "dinner_id")
    private Meal dinner;

    // AI / Admin
    private String generatedBy;

    // ACTIVE / COMPLETED
    private String status;
}