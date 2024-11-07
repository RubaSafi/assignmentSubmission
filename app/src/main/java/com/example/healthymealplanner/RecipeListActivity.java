package com.example.healthymealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthymealplanner.adapters.RecipeAdapter;
import com.example.healthymealplanner.models.Recipe;

import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity {
    private ListView recipeListView;
    private TextView noResultsTextView;
    private RecipeAdapter recipeAdapter;
    private ArrayList<Recipe> filteredRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        recipeListView = findViewById(R.id.recipeListView);
        noResultsTextView = findViewById(R.id.noResultsTextView);

        Intent intent = getIntent();
        String keyword = intent.getStringExtra("keyword");
        String mealType = intent.getStringExtra("mealType");
        String dietaryPreference = intent.getStringExtra("dietaryPreference");
        boolean isGlutenFree = intent.getBooleanExtra("isGlutenFree", false);
        boolean isDairyFree = intent.getBooleanExtra("isDairyFree", false);
        boolean isNutFree = intent.getBooleanExtra("isNutFree", false);

        // get sample recipes and filter them
        ArrayList<Recipe> allRecipes = Recipe.getSampleRecipes();
        filteredRecipes = filterRecipes(allRecipes, keyword, mealType, dietaryPreference, isGlutenFree, isDairyFree, isNutFree);

        if (filteredRecipes.isEmpty()) {
            // show no results message
            noResultsTextView.setVisibility(View.VISIBLE);
            recipeListView.setVisibility(View.GONE);
        } else {
            // display recipes in list view
            noResultsTextView.setVisibility(View.GONE);
            recipeListView.setVisibility(View.VISIBLE);
            recipeAdapter = new RecipeAdapter(this, filteredRecipes);
            recipeListView.setAdapter(recipeAdapter);

            recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    Recipe selectedRecipe = filteredRecipes.get(position);
                    Intent detailIntent = new Intent(RecipeListActivity.this, RecipeDetailActivity.class);
                    detailIntent.putExtra("recipeName", selectedRecipe.getRecipeName());
                    detailIntent.putExtra("ingredients", selectedRecipe.getIngredients());
                    detailIntent.putExtra("instructions", selectedRecipe.getInstructions());
                    detailIntent.putExtra("imageResource", R.drawable.placeholder_image);
                    startActivity(detailIntent);
                }
            });
        }
    }

    private ArrayList<Recipe> filterRecipes(ArrayList<Recipe> recipes, String keyword, String mealType,
                                            String dietaryPreference, boolean isGlutenFree, boolean isDairyFree, boolean isNutFree) {
        ArrayList<Recipe> filteredList = new ArrayList<>();

        for (Recipe recipe : recipes) {
            boolean matchesKeyword = keyword.isEmpty() ||
                    recipe.getRecipeName().toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.getIngredients().toLowerCase().contains(keyword.toLowerCase());
            boolean matchesMealType = mealType.equals("Any") || recipe.getMealType().equalsIgnoreCase(mealType);
            boolean matchesDietaryPreference = dietaryPreference.equals("Any") || recipe.getDietaryPreference().equalsIgnoreCase(dietaryPreference);
            boolean matchesGlutenFree = !isGlutenFree || recipe.isGlutenFree();
            boolean matchesDairyFree = !isDairyFree || recipe.isDairyFree();
            boolean matchesNutFree = !isNutFree || recipe.isNutFree();

            if (matchesKeyword && matchesMealType && matchesDietaryPreference &&
                    matchesGlutenFree && matchesDairyFree && matchesNutFree) {
                filteredList.add(recipe);
            }
        }

        return filteredList;
    }
}
