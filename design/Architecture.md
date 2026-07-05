# Project Architecture

## Project Name

MealMate AI

---

# Architecture Style

Layered Architecture

Client → Controller → Service → Repository → Database

---

# Technology Stack

Frontend

- React
- HTML
- CSS
- Tailwind CSS
- JavaScript
- Axios

Backend

- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication

Database

- MySQL

Build Tool

- Maven

Testing

- JUnit
- Mockito
- Postman

Version Control

- Git
- GitHub

Deployment

- Docker
- Railway / Render

AI

- OpenAI API (Future)
- Gemini API (Future)

---

# System Architecture

```
                React Frontend
                       │
                       │ HTTP / REST API
                       ▼
              Spring Boot Backend
                       │
        ┌──────────────┼──────────────┐
        │              │              │
        ▼              ▼              ▼
  Spring Security   Business Logic   AI Service
        │              │              │
        └──────────────┼──────────────┘
                       ▼
               Repository Layer
                       │
                       ▼
                    MySQL
```

---

# Backend Layer Structure

```
Controller

↓

Service

↓

Repository

↓

Entity

↓

Database
```

---

# Package Structure

```
com.mealmate

│

├── config

├── controller

├── dto

├── entity

├── exception

├── repository

├── security

├── service

├── util

├── mapper

└── validation
```

---

# Authentication Flow

```
User

↓

Login

↓

JWT Authentication

↓

Spring Security

↓

Protected APIs
```

---

# AI Flow

```
User Preference

↓

Health Profile

↓

Diet Preference

↓

Meal Generation Request

↓

AI Engine

↓

Meal Recommendation

↓

Meal Plan
```

---

# Database Flow

```
Role

↓

User

├── HealthProfile

├── DietPreference

├── MealPlan

│       └── Meal

│              └── Recipe

│                      ├── RecipeVideo

│                      └── RecipeIngredient

│                               └── Ingredient

│

├── GroceryList

│       └── GroceryItem

│

├── Favorite

├── Review

├── Notification

│

└── GroupMember

        └── Group
```

---

# Development Workflow

Planning

↓

Documentation

↓

Database Design

↓

Spring Boot Setup

↓

Authentication

↓

User Module

↓

Meal Planner Module

↓

Recipe Module

↓

AI Module

↓

Frontend

↓

Testing

↓

Deployment

---

# Design Principles

- Layered Architecture
- SOLID Principles
- Clean Code
- RESTful APIs
- Database Normalization
- JWT Authentication
- Reusable Components
- Scalable Design

---

# Project Version

Version : V1.0

Status : Architecture Finalized