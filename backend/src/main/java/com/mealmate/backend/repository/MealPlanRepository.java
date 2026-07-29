package com.mealmate.backend.repository;

import com.mealmate.backend.entity.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {
    Optional<MealPlan> findByUserIdAndMealDate(Long userId, LocalDate mealDate);
    List<MealPlan> findByUserIdOrderByMealDateDesc(Long userId);
}