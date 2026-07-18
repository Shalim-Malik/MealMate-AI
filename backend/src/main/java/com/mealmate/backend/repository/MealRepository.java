package com.mealmate.backend.repository;

import com.mealmate.backend.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}