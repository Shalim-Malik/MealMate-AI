package com.mealmate.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String dietType;
    // Vegetarian
    // Non-Vegetarian
    // Vegan
    // Jain

    private String goal;
    // Weight Loss
    // Weight Gain
    // Muscle Gain
    // Maintain

    private String budget;
    // Low
    // Medium
    // High

    private String region;
    // North India
    // South India
    // East India
    // West India

    private String allergies;
    // Peanut, Milk, Soy...

    private String dislikedFoods;
    // Brinjal, Mushroom...

    private Integer mealsPerDay;

    private Boolean spicyFood;

    private Boolean seasonalFood;

    private Boolean aiAutoUpdate;
}