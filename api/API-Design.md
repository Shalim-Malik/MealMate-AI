# API Design

## Overview

This document defines the REST APIs for MealMate AI Version 1.

Base URL

/api/v1

---

# Authentication APIs

## Register User

POST /auth/register

Description:
Register a new user.

---

## Login

POST /auth/login

Description:
Authenticate user and return JWT Token.

---

## Logout

POST /auth/logout

Description:
Logout current user.

---

## Forgot Password

POST /auth/forgot-password

Description:
Send password reset link.

---

## Reset Password

POST /auth/reset-password

Description:
Reset account password.

---

# User APIs

## Get User Profile

GET /users/profile

---

## Update User Profile

PUT /users/profile

---

## Upload Profile Image

POST /users/profile/image

---

## Delete Account

DELETE /users/profile

---

# Health Profile APIs

GET /health-profile

POST /health-profile

PUT /health-profile

DELETE /health-profile

---

# Diet Preference APIs

GET /diet-preference

POST /diet-preference

PUT /diet-preference

DELETE /diet-preference

---

# Meal Plan APIs

GET /meal-plans

GET /meal-plans/{id}

POST /meal-plans

PUT /meal-plans/{id}

DELETE /meal-plans/{id}

---

# Meal APIs

GET /meals

GET /meals/{id}

POST /meals

PUT /meals/{id}

DELETE /meals/{id}

PATCH /meals/{id}/complete

Description:
Mark meal as completed.

---

# Recipe APIs

GET /recipes

GET /recipes/{id}

POST /recipes

PUT /recipes/{id}

DELETE /recipes/{id}

GET /recipes/search

Description:
Search recipes.

---

# Recipe Video APIs

GET /recipes/{id}/videos

POST /recipes/{id}/videos

DELETE /videos/{id}

---

# Ingredient APIs

GET /ingredients

POST /ingredients

PUT /ingredients/{id}

DELETE /ingredients/{id}

---

# Grocery APIs

GET /grocery-lists

POST /grocery-lists

GET /grocery-lists/{id}

DELETE /grocery-lists/{id}

---

# Group APIs

GET /groups

GET /groups/{id}

POST /groups

PUT /groups/{id}

DELETE /groups/{id}

---

# Group Member APIs

POST /groups/{id}/join

POST /groups/{id}/leave

POST /groups/{id}/members

DELETE /groups/{id}/members/{memberId}

---

# Favorite APIs

GET /favorites

POST /favorites

DELETE /favorites/{id}

---

# Review APIs

POST /reviews

PUT /reviews/{id}

DELETE /reviews/{id}

GET /recipes/{id}/reviews

---

# Notification APIs

GET /notifications

PATCH /notifications/{id}/read

DELETE /notifications/{id}

---

# AI APIs

POST /ai/generate-meal-plan

POST /ai/recommend-recipes

POST /ai/grocery-list

POST /ai/nutrition-analysis

POST /ai/meal-template

---

# Admin APIs

GET /admin/users

GET /admin/groups

GET /admin/recipes

GET /admin/reports

DELETE /admin/users/{id}

DELETE /admin/recipes/{id}

---

# API Status

Version : V1.0

Status : Initial Design Complete