package com.example.healthymealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {
    private ImageView recipeImageView;
    private TextView recipeNameTextView;
    private TextView ingredientsTextView;
    private TextView instructionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        recipeImageView = findViewById(R.id.recipeImageView);
        recipeNameTextView = findViewById(R.id.recipeNameTextView);
        ingredientsTextView = findViewById(R.id.ingredientsTextView);
        instructionsTextView = findViewById(R.id.instructionsTextView);

        Intent intent = getIntent();
        String recipeName = intent.getStringExtra("recipeName");
        String ingredients = intent.getStringExtra("ingredients");
        String instructions = intent.getStringExtra("instructions");
        int imageResource = intent.getIntExtra("imageResource", R.drawable.placeholder_image);

        recipeImageView.setImageResource(imageResource);
        recipeNameTextView.setText(recipeName);
        ingredientsTextView.setText(ingredients);
        instructionsTextView.setText(instructions);
    }
}
