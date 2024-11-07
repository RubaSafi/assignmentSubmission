package com.example.healthymealplanner.models;

import java.util.ArrayList;

public class Recipe {
    private String recipeName;
    private String mealType;
    private String dietaryPreference;
    private boolean isGlutenFree;
    private boolean isDairyFree;
    private boolean isNutFree;
    private String ingredients;
    private String instructions;

    public Recipe(String recipeName, String mealType, String dietaryPreference,
                  boolean isGlutenFree, boolean isDairyFree, boolean isNutFree,
                  String ingredients, String instructions) {
        this.recipeName = recipeName;
        this.mealType = mealType;
        this.dietaryPreference = dietaryPreference;
        this.isGlutenFree = isGlutenFree;
        this.isDairyFree = isDairyFree;
        this.isNutFree = isNutFree;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getMealType() {
        return mealType;
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public boolean isDairyFree() {
        return isDairyFree;
    }

    public boolean isNutFree() {
        return isNutFree;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public static ArrayList<Recipe> getSampleRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe(
                "Quinoa Salad",
                "Lunch",
                "Vegan",
                true,
                true,
                true,
                "Quinoa, cucumber, tomato, olive oil, lemon juice",
                "Cook quinoa. Chop vegetables. Mix everything together."
        ));

        recipes.add(new Recipe(
                "Chicken Stir Fry",
                "Dinner",
                "Any",
                true,
                true,
                true,
                "Chicken breast, bell peppers, broccoli, soy sauce",
                "Stir-fry chicken. Add vegetables. Add soy sauce."
        ));

        recipes.add(new Recipe(
                "Gluten-Free Pancakes",
                "Breakfast",
                "Vegetarian",
                true,
                false,
                false,
                "Gluten-free flour, milk, eggs, baking powder",
                "Mix ingredients. Cook on griddle."
        ));

        recipes.add(new Recipe(
                "Almond Butter Smoothie",
                "Snacks",
                "Vegan",
                true,
                true,
                false,
                "Almond butter, banana, almond milk, chia seeds",
                "Blend all ingredients until smooth."
        ));

        recipes.add(new Recipe(
                "Grilled Salmon",
                "Dinner",
                "Paleo",
                true,
                true,
                true,
                "Salmon fillet, lemon, garlic, herbs",
                "Season salmon. Grill until cooked."
        ));

        return recipes;
    }
}
