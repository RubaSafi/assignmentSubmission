package com.example.healthymealplanner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthymealplanner.R;
import com.example.healthymealplanner.models.Recipe;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Recipe recipe = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_list_item, parent, false);
        }

        TextView recipeNameTextView = convertView.findViewById(R.id.recipeItemNameTextView);
        TextView mealTypeTextView = convertView.findViewById(R.id.recipeItemMealTypeTextView);
        ImageView dietaryPreferenceIcon = convertView.findViewById(R.id.dietaryPreferenceIcon);

        recipeNameTextView.setText(recipe.getRecipeName());
        mealTypeTextView.setText(recipe.getMealType());

        if (recipe.getDietaryPreference().equalsIgnoreCase("Vegan")) {
            dietaryPreferenceIcon.setImageResource(R.drawable.ic_vegan);
        } else if (recipe.getDietaryPreference().equalsIgnoreCase("Vegetarian")) {
            dietaryPreferenceIcon.setImageResource(R.drawable.ic_vegetarian);
        } else if (recipe.getDietaryPreference().equalsIgnoreCase("Paleo")) {
            dietaryPreferenceIcon.setImageResource(R.drawable.ic_paleo);
        } else {
            dietaryPreferenceIcon.setVisibility(View.GONE);
        }

        return convertView;
    }
}
