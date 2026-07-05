# ER Diagram

## Overview

This document describes the relationship between all entities used in the MealMate AI database.

---

## Entity Relationship Diagram

```text
                               +----------------+
                               |      Role      |
                               +----------------+
                               | PK id          |
                               | role_name      |
                               | description    |
                               +--------+-------+
                                        |
                                        | 1
                                        |
                                        | N
+---------------------------------------------------------------+
|                           User                                |
+---------------------------------------------------------------+
| PK id                                                        |
| full_name                                                    |
| email                                                        |
| password                                                     |
| phone_number                                                 |
| date_of_birth                                                |
| gender                                                       |
| occupation                                                   |
| city                                                         |
| state                                                        |
| country                                                      |
| profile_image_url                                            |
| email_verified                                               |
| account_status                                               |
| FK role_id                                                   |
+---------------------------------------------------------------+
      |1
      |
      |1
      ▼
+----------------------+
|   HealthProfile      |
+----------------------+
| PK id                |
| FK user_id           |
| height_cm            |
| weight_kg            |
| target_weight        |
| goal                 |
| daily_calorie_target |
| activity_level       |
| medical_condition    |
+----------------------+

      |1
      |
      |1
      ▼
+----------------------+
|  DietPreference      |
+----------------------+
| PK id                |
| FK user_id           |
| diet_type            |
| spice_level          |
| allergies            |
| cuisine_preference   |
+----------------------+

      |1
      |
      |N
      ▼
+----------------------+
|      MealPlan        |
+----------------------+
| PK id                |
| FK user_id           |
| plan_name            |
| plan_type            |
| start_date           |
| end_date             |
| budget               |
| ai_generated         |
| status               |
+----------------------+
      |
      |1
      |
      |N
      ▼
+----------------------+
|        Meal          |
+----------------------+
| PK id                |
| FK meal_plan_id      |
| FK recipe_id         |
| meal_type            |
| meal_date            |
| serving_size         |
| notes                |
| is_completed         |
+----------------------+
      |
      |N
      |
      |1
      ▼
+----------------------+
|       Recipe         |
+----------------------+
| PK id                |
| recipe_name          |
| description          |
| image_url            |
| cooking_time         |
| difficulty           |
| calories             |
| protein              |
| carbs                |
| fat                  |
| fiber                |
| meal_category        |
+----------------------+
      |
      |1
      |
      +-------------------------------+
      |                               |
      |                               |
      ▼                               ▼
+---------------------+      +----------------------+
|    RecipeVideo      |      | RecipeIngredient     |
+---------------------+      +----------------------+
| PK id               |      | PK id               |
| FK recipe_id        |      | FK recipe_id        |
| video_title         |      | FK ingredient_id    |
| channel_name        |      | quantity            |
| youtube_url         |      | unit                |
| language            |      +----------+----------+
+---------------------+                 |
                                        |
                                        | N
                                        |
                                        |1
                                        ▼
                               +----------------------+
                               |     Ingredient       |
                               +----------------------+
                               | PK id               |
                               | ingredient_name     |
                               | unit                |
                               +----------------------+

+----------------------+
|    GroceryList       |
+----------------------+
| PK id                |
| FK user_id           |
| FK meal_plan_id      |
| week_start           |
| week_end             |
| estimated_cost       |
+----------+-----------+
           |
           |1
           |
           |N
           ▼
+----------------------+
|    GroceryItem       |
+----------------------+
| PK id                |
| FK grocery_list_id   |
| FK ingredient_id     |
| quantity             |
| purchased            |
+----------------------+

+----------------------+
|       Group          |
+----------------------+
| PK id                |
| group_name           |
| group_type           |
| FK created_by        |
+----------+-----------+
           |
           |1
           |
           |N
           ▼
+----------------------+
|    GroupMember       |
+----------------------+
| PK id                |
| FK group_id          |
| FK user_id           |
| joined_at            |
+----------------------+

+----------------------+
|    Notification      |
+----------------------+
| PK id                |
| FK user_id           |
| title                |
| message              |
| notification_type    |
| is_read              |
+----------------------+

+----------------------+
|      Favorite        |
+----------------------+
| PK id                |
| FK user_id           |
| FK recipe_id         |
+----------------------+

+----------------------+
|       Review         |
+----------------------+
| PK id                |
| FK user_id           |
| FK recipe_id         |
| rating               |
| comment              |
+----------------------+

+----------------------+
|    MealTemplate      |
+----------------------+
| PK id                |
| template_name        |
| description          |
| category             |
| FK created_by        |
| is_public            |
+----------------------+
```

---

# Relationship Summary

## One-to-One (1:1)

- User → HealthProfile
- User → DietPreference

---

## One-to-Many (1:N)

- Role → User
- User → MealPlan
- MealPlan → Meal
- Recipe → Meal
- Recipe → RecipeVideo
- Recipe → RecipeIngredient
- Ingredient → RecipeIngredient
- User → GroceryList
- GroceryList → GroceryItem
- Group → GroupMember
- User → Notification
- User → Favorite
- User → Review

---

## Many-to-Many (Resolved using Junction Tables)

- Recipe ↔ Ingredient (RecipeIngredient)
- User ↔ Group (GroupMember)

---

# Database Flow

Role
↓
User
├── HealthProfile
├── DietPreference
├── MealPlan
│     └── Meal
│            └── Recipe
│                   ├── RecipeVideo
│                   └── RecipeIngredient
│                           └── Ingredient
│
├── GroceryList
│      └── GroceryItem
│
├── Favorite
├── Review
├── Notification
│
└── GroupMember
└── Group

---

# ER Diagram Version

Version : V1.0
Status : Initial Design Completed