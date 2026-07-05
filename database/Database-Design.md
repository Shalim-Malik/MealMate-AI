# Database Design

## Overview

This document defines the Version 1 database schema for the MealMate AI platform.

The database is designed using normalization principles to reduce redundancy and improve scalability. The architecture supports AI-generated meal plans, recipe management, grocery planning, family/group collaboration, and future AI features.

---

# Entity 1: User

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| full_name | VARCHAR(255) | User Full Name |
| email | VARCHAR(255) | Unique Email |
| password | VARCHAR(255) | BCrypt Hashed Password |
| phone_number | VARCHAR(15) | Mobile Number |
| date_of_birth | DATE | User DOB |
| gender | VARCHAR(20) | Male / Female / Other |
| occupation | VARCHAR(100) | Student, Employee, Housewife, etc. |
| city | VARCHAR(100) | Current City |
| state | VARCHAR(100) | Current State |
| country | VARCHAR(100) | Current Country |
| profile_image_url | VARCHAR(255) | Profile Image URL |
| email_verified | BOOLEAN | Email Verification Status |
| account_status | VARCHAR(20) | ACTIVE / BLOCKED / INACTIVE |
| role_id | BIGINT | Foreign Key (Role) |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 2: Role

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| role_name | VARCHAR(50) | USER / ADMIN / GROUP_ADMIN |
| description | VARCHAR(255) | Role Description |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 3: HealthProfile

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| height_cm | DECIMAL(5,2) | Height in CM |
| weight_kg | DECIMAL(5,2) | Current Weight |
| target_weight | DECIMAL(5,2) | Target Weight |
| goal | VARCHAR(50) | Weight Loss / Weight Gain / Muscle Gain |
| daily_calorie_target | INT | Daily Calories |
| activity_level | VARCHAR(30) | Low / Medium / High |
| medical_condition | VARCHAR(255) | Diabetes, BP, etc. |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 4: DietPreference

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| diet_type | VARCHAR(50) | Veg / Non-Veg / Vegan / Jain |
| spice_level | VARCHAR(30) | Mild / Medium / Spicy |
| allergies | VARCHAR(255) | User Allergies |
| cuisine_preference | VARCHAR(100) | Indian / Chinese / Italian |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 5: MealPlan

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| plan_name | VARCHAR(100) | Weekly Plan / Monthly Plan |
| plan_type | VARCHAR(20) | DAILY / WEEKLY / MONTHLY |
| start_date | DATE | Start Date |
| end_date | DATE | End Date |
| budget | DECIMAL(10,2) | Planned Budget |
| ai_generated | BOOLEAN | AI Generated or Manual |
| status | VARCHAR(20) | ACTIVE / COMPLETED |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 6: Meal

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| meal_plan_id | BIGINT | Foreign Key (MealPlan) |
| recipe_id | BIGINT | Foreign Key (Recipe) |
| meal_type | VARCHAR(20) | BREAKFAST / LUNCH / SNACKS / DINNER |
| meal_date | DATE | Meal Date |
| serving_size | INT | Number of Servings |
| notes | VARCHAR(255) | User Notes |
| is_completed | BOOLEAN | Meal Completed |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 7: Recipe

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| recipe_name | VARCHAR(150) | Recipe Name |
| description | TEXT | Recipe Description |
| image_url | VARCHAR(255) | Recipe Image |
| cooking_time | INT | Minutes |
| difficulty | VARCHAR(20) | EASY / MEDIUM / HARD |
| calories | INT | Calories |
| protein | DECIMAL(5,2) | Protein |
| carbs | DECIMAL(5,2) | Carbohydrates |
| fat | DECIMAL(5,2) | Fat |
| fiber | DECIMAL(5,2) | Fiber |
| meal_category | VARCHAR(30) | Breakfast / Lunch / Dinner |
| is_vegetarian | BOOLEAN | Veg |
| is_vegan | BOOLEAN | Vegan |
| is_jain | BOOLEAN | Jain |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 8: Ingredient

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| ingredient_name | VARCHAR(150) | Ingredient Name |
| unit | VARCHAR(20) | gm / ml / pcs |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 9: RecipeIngredient

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| recipe_id | BIGINT | Foreign Key (Recipe) |
| ingredient_id | BIGINT | Foreign Key (Ingredient) |
| quantity | DECIMAL(8,2) | Required Quantity |
| unit | VARCHAR(20) | Unit |

---

# Entity 10: RecipeVideo

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| recipe_id | BIGINT | Foreign Key (Recipe) |
| video_title | VARCHAR(255) | Video Title |
| channel_name | VARCHAR(150) | Channel Name |
| youtube_url | VARCHAR(255) | YouTube URL |
| language | VARCHAR(50) | Video Language |
| created_at | TIMESTAMP | Created Time |

---

# Entity 11: GroceryList

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| meal_plan_id | BIGINT | Foreign Key (MealPlan) |
| week_start | DATE | Week Start |
| week_end | DATE | Week End |
| estimated_cost | DECIMAL(10,2) | Estimated Cost |
| created_at | TIMESTAMP | Created Time |

---

# Entity 12: GroceryItem

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| grocery_list_id | BIGINT | Foreign Key (GroceryList) |
| ingredient_id | BIGINT | Foreign Key (Ingredient) |
| quantity | DECIMAL(8,2) | Quantity |
| purchased | BOOLEAN | Purchased or Not |

---

# Entity 13: Group

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| group_name | VARCHAR(100) | Group Name |
| group_type | VARCHAR(30) | Family / Hostel / Office |
| created_by | BIGINT | Foreign Key (User) |
| created_at | TIMESTAMP | Created Time |

---

# Entity 14: GroupMember

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| group_id | BIGINT | Foreign Key (Group) |
| user_id | BIGINT | Foreign Key (User) |
| joined_at | TIMESTAMP | Joined Time |

---

# Entity 15: Notification

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| title | VARCHAR(100) | Notification Title |
| message | TEXT | Notification Message |
| notification_type | VARCHAR(50) | SYSTEM / REMINDER |
| is_read | BOOLEAN | Read Status |
| created_at | TIMESTAMP | Created Time |
| updated_at | TIMESTAMP | Updated Time |

---

# Entity 16: Favorite

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| recipe_id | BIGINT | Foreign Key (Recipe) |
| created_at | TIMESTAMP | Created Time |

---

# Entity 17: Review

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| user_id | BIGINT | Foreign Key (User) |
| recipe_id | BIGINT | Foreign Key (Recipe) |
| rating | DECIMAL(2,1) | Rating (0.0–5.0) |
| comment | TEXT | User Review |
| created_at | TIMESTAMP | Created Time |

---

# Entity 18: MealTemplate

| Column | Data Type | Description |
|---------|----------|-------------|
| id | BIGINT | Primary Key |
| template_name | VARCHAR(100) | Template Name |
| description | TEXT | Template Description |
| category | VARCHAR(50) | Weight Loss / Gym / Family |
| created_by | BIGINT | Foreign Key (User) |
| is_public | BOOLEAN | Public / Private |
| created_at | TIMESTAMP | Created Time |

---

# Database Relationships

- One Role → Many Users
- One User → One HealthProfile
- One User → One DietPreference
- One User → Many MealPlans
- One MealPlan → Many Meals
- One Recipe → Many Meals
- One Recipe → Many RecipeVideos
- One Recipe → Many RecipeIngredients
- One Ingredient → Many RecipeIngredients
- One User → Many GroceryLists
- One GroceryList → Many GroceryItems
- One Group → Many GroupMembers
- One User → Many Notifications
- One User → Many Favorites
- One User → Many Reviews

---

# Database Version

**Version:** V1.0 (Initial Design)

> Note: This schema may evolve during implementation as new features are added or optimized.