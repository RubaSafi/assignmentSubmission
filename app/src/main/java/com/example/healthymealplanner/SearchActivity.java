package com.example.healthymealplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    private EditText keywordEditText;
    private Spinner mealTypeSpinner;
    private RadioGroup dietaryRadioGroup;
    private RadioButton anyDietRadioButton, veganRadioButton, vegetarianRadioButton, paleoRadioButton;
    private CheckBox glutenFreeCheckBox, dairyFreeCheckBox, nutFreeCheckBox;
    private Button searchRecipesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        keywordEditText = findViewById(R.id.keywordEditText);
        mealTypeSpinner = findViewById(R.id.mealTypeSpinner);
        dietaryRadioGroup = findViewById(R.id.dietaryRadioGroup);
        anyDietRadioButton = findViewById(R.id.anyDietRadioButton);
        veganRadioButton = findViewById(R.id.veganRadioButton);
        vegetarianRadioButton = findViewById(R.id.vegetarianRadioButton);
        paleoRadioButton = findViewById(R.id.paleoRadioButton);
        glutenFreeCheckBox = findViewById(R.id.glutenFreeCheckBox);
        dairyFreeCheckBox = findViewById(R.id.dairyFreeCheckBox);
        nutFreeCheckBox = findViewById(R.id.nutFreeCheckBox);
        searchRecipesButton = findViewById(R.id.searchRecipesButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meal_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mealTypeSpinner.setAdapter(adapter);

        searchRecipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collectSearchCriteria();
            }
        });
    }

    private void collectSearchCriteria() {
        String keyword = keywordEditText.getText().toString().trim();
        String mealType = mealTypeSpinner.getSelectedItem().toString();
        String dietaryPreference = getSelectedDietaryPreference();
        boolean isGlutenFree = glutenFreeCheckBox.isChecked();
        boolean isDairyFree = dairyFreeCheckBox.isChecked();
        boolean isNutFree = nutFreeCheckBox.isChecked();

        Intent intent = new Intent(SearchActivity.this, RecipeListActivity.class);
        intent.putExtra("keyword", keyword);
        intent.putExtra("mealType", mealType);
        intent.putExtra("dietaryPreference", dietaryPreference);
        intent.putExtra("isGlutenFree", isGlutenFree);
        intent.putExtra("isDairyFree", isDairyFree);
        intent.putExtra("isNutFree", isNutFree);
        startActivity(intent);
    }

    private String getSelectedDietaryPreference() {
        int selectedId = dietaryRadioGroup.getCheckedRadioButtonId();
        if (selectedId == anyDietRadioButton.getId()) {
            return "Any";
        } else if (selectedId == veganRadioButton.getId()) {
            return "Vegan";
        } else if (selectedId == vegetarianRadioButton.getId()) {
            return "Vegetarian";
        } else if (selectedId == paleoRadioButton.getId()) {
            return "Paleo";
        } else {
            return "Any";
        }
    }
}
